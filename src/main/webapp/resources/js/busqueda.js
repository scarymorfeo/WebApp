
var tabla;

$(document).ready(function() {
	handler();
	//alert("xxxxxxxxxxxxxxxxx");
});


function handler() {
	
	$("#btnBuscar").click(function() {
		tabla.ajax.reload();
	});	
	
	initTabla();
}


function initTabla() {
	
	var columns = [ {
		data : 'penumper'
	}, {
		data : 'nombre'
	}, {
		data : 'rfc'
	}, {
		data : 'score'
	} ];

	tabla = $('#tabla-busqueda').DataTable({
        "processing" : true,
        "ajax" : {
            "url" : "consultarBusqueda.json",
            "dataSrc": function (json){
                if(json.estatus == "ok"){
                	Messages.messageOk(json.mensaje);
                    
                }else{
                	Messages.messageError(json.mensaje);
                }
                
                return json.lista;
            },          
            "data": function ( d ) {
                return $.extend( {}, d, {
                  "param": $("#txtValor").val(),
                  "param2": $("#txtValorRfc").val()
                } );
             }, 
             "error": function (xhr, error, thrown) {
            	 
            	 alert( 'Error al inicializar la tabla' );
             }
            	
        },
        "language" : dtLanguage,
        "columns" : columns
    });
	
	
	function callB (response){
		console.info("exitoso");
	}
	
	/*tabla = $('#tabla-busqueda').dataTable( {
		    "bProcessing": true,
		    "bServerSide": true,
		    "sAjaxSource": "consultarBusqueda.json",
	        "language" : dtLanguage,
	        "columns" : columns,		
	        "fnServerParams": function (aoData) {
	        	aoData.push({
	        	"name": "param",
	        	"value": $("#txtValor").val()
	        	})
	        	aoData.push({
	        	"name": "param2",
	        	"value": $("#txtValorRfc").val()
	        	})

	        	},	        
		    "fnServerData": function ( sSource, aoData, callB, oSettings ) {
		      oSettings.jqXHR = $.ajax( {
		        "dataType": 'json',
		        "type": "GET",
		        "dataSrc" : 'lista',
		        "url": sSource,
		        "data": aoData,
		        "success": callB
		      } );
		    }
	} );*/	

}
