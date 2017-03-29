/**
 * 
 */
package com.infomg.app.dao;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.infomg.app.bean.UsuarioApBean;
import com.infomg.commons.exceptions.DAOException;

import ssa.ssase.ClieSock;
import ssa.ssautil.SSAAPIException;
import ssa.ssautil.SSAInterruptedException;
import ssa.ssautil.SSASocketException;

/**
 * @author Omartinez
 *
 */
@Repository
public class BusquedaIIRDaoImpl implements BusquedaIIRDao{

	private String			hostname;
	private String			rbname;
	private int			hostport = -1;
	private boolean			searchStarted = false;
	private ssa.ssase.ClieSock	ssaids;
	private static final String	search = "NOMBRE_AM";
	private static final String	prog = "xxxxxxxxxx";
	
	@Override
	public List<UsuarioApBean> getListaClientes(String param)throws DAOException{
		String args []= {"-hlocalhost:1666","-rodb:0:SSA_TGT/SSA_TGT00@IIR"};
		
	List<UsuarioApBean> listaUsuarios =  SearchIIRClien(args,param);
	
//        UsuarioApBean usr = new UsuarioApBean();
//
//        usr.setPenumper("sss"); 
//        usr.setNombre("Nombre Usuario 1");
//        usr.setRfc("USR00001");
//
//        
//        listaUsuarios.add(usr);
		
		return listaUsuarios;
		
	}
	
	
	public
	List<UsuarioApBean> SearchIIRClien (
		String[]	args, String param)
	{
		byte[][]	parameters;
		int[]		datalen;
		byte[]		rec;
		int[]		recs;
		int[]		score;
		int[]		sreps;
		int[]		freps;
		List<UsuarioApBean> listaUsuarios = new ArrayList<UsuarioApBean>();
		

		datalen = new int[1];
		recs = new int[1];
		score = new int[1];
		sreps = new int[0];
		freps = new int[0];

		try {
			getArgs (args);
		} catch (Exception e) {
			die (e.getMessage ());
		}

	/* Construct parameters for the search
	*/
		parameters = new byte[3][];
		parameters[0] = "TRINIDAD                                                                                            ".getBytes();
		parameters[1] = "PIAT830207BU4                                                                                       ".getBytes();                 
		parameters[2] = "                                                                                                    ".getBytes();                 

	/* Connect to the Search Server
	*/
		try {
			ssaids = new ClieSock (hostname, hostport);
	/* Begin the search
	*/
			ssaids.ids_system_search_start (
				rbname,		/* IN: Rulebase name */
				"ALTASMASIVAS",	/* IN: System name */
				"-v0",		/* IN: Verbosity */
				"",		/* IN: options */
				search,		/* IN: Search name */
				parameters,	/* IN: Search values */
				"",		/* IN: Answerset prefix
						 * (not used) */
				datalen,	/* OUT: Record length */
				recs);		/* OUT: Number of records */
			searchStarted = true;

	/* Allocate data array for output
	*/
			rec = new byte[datalen[0]];

	/* Get the result set
	*/
			if (recs[0] > 0) {
				UsuarioApBean usr =new UsuarioApBean();
				while (0 == ssaids.ids_search_get (
						search,		// IN: search name
						rec,		// OUT: search data
						datalen[0],	// IN: Length of rec
						score,		// OUT: the score
						sreps, 0,	// OUT: source fields
						freps, 0)) {	// OUT: file fields
					System.out.println (prog +
						"> IDT_Record = '"
						+ new String (rec) + "'");

					System.out.println (prog + "> Score = " +
						score[0]);
					usr = new UsuarioApBean();
					usr.setPenumper(rec.toString().substring(1,8));
					usr.setNombre(rec.toString().substring(1,8));
					usr.setRfc(rec.toString().substring(1,8));
					usr.setScore(score[0]);
					listaUsuarios.add(usr);
				}
			}
			ssaids.ids_system_search_finish ();
			ssaids.ids_disconnect ();
		} catch (SSAInterruptedException e) {
			die (e.getMessage ());
		} catch (SSAAPIException e) {
			die (e);
		} catch (SSASocketException e) {
			die (e.getMessage ());
		}
		return listaUsuarios;
	}


	
	private void
	getArgs (
		String[]	args) throws Exception
	{
		int i;

		if (args.length != 2) {
			throw new Exception("Incorrect number of arguments: " +
					    args.length);
		}

		for (i = 0; i < 2; ++i) {
			if (args[i].startsWith ("?") ||
			    args[i].charAt(1) == '?')
				die("Usage: sample1 -r<rules> -h<host>");
			if (args[i].charAt(0) != '-')
				throw new Exception("Bad argument: " + args[i]);
			switch(args[i].charAt(1)) {
			case 'H':
			case 'h':
				hostParse(args[i].substring (2));
				break;

			case 'R':
			case 'r':
				rbname = args[i].substring (2);
				break;

			default:
				throw new Exception ("Bad Option: " + args[i]);
			}
		}

	/* Check that everything was set
	*/
		if (null == hostname || null == rbname || hostport < 0)
			throw new Exception ("Parameters not set");
	}

	private void
	hostParse (
		String	hostString) throws Exception
	{
		int colonIndex;

		colonIndex = hostString.indexOf (':');
		if (colonIndex < 0) {
			throw new Exception ("host port error '" + hostString  +
				"' format host:port");
		}
		hostname = hostString.substring (0, colonIndex);
		hostport = Integer.parseInt (hostString.substring (colonIndex + 1));
	}

	private void
	die (
		SSAAPIException	err)
	{
		String[]		log;

		log = new String[1];
		System.out.println (prog + "> Exception: (" + err.getRc () + ") " +
					err.getMessage ());

		try {
			while (0 == ssaids.ids_errors_get_all (log, ssaids.MSG_SIZE))
				System.out.println ("ErrorLog: " + log[0]);
		} catch (SSAAPIException e) {
			die (e.getMessage ());
		} catch (SSASocketException e) {
			die (e.getMessage ());
		}
		die ();
	}

	private void
	die (
		String	message)
	{
		System.out.println (prog + "> " + message);
		die ();
	}

	private void
	die ()
	{
		if (null != ssaids) {
			try {
				if (searchStarted) {
					ssaids.ids_system_search_finish ();
				}
				ssaids.ids_disconnect ();
			} catch (SSAAPIException e) {
				System.out.println (prog + "> Exception: (" +
					e.getRc () + ") " + e.getMessage ());
			} catch (SSASocketException e) {
				System.out.println (prog + "> Exception: " +
					" " + e.getMessage ());
			}
		}
		System.exit(1);
	}
	

}
