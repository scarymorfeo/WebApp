$(document).ready(function() {
	handler();
	//alert("xxxxxxxxxxxxxxxxx");
});


function handler() {
	
	$("#btnBuscar").click(function() {
		 var paramValue = $("#txtValor").val();
		 
		 $.ajax({
	            url : 'consultarBusqueda.json',
	            type : 'GET',
	            dataType : 'json',
	            data:{
	            	param:paramValue
	            },
	            success : function(respuesta) {
	            	tabla.destroy();
	                assignToEventsColumns(respuesta.lista);
	            }
	        });

	        function assignToEventsColumns(data) {
	            tabla = $('#tabla-busqueda').dataTable({
	                "bAutoWidth" : false,
	                "processing" : true,
	                "aaData" : data,
	                "language" : dtLanguage,
	                "columns" : [ {
	                    "data" : "penumper"
	                }, {
	                    "data" : "nombre"
	                }, {
	                    "data" : "rfc"
	                }, {
	                    "data" : "score"
	                }]
	            })
	        }		 
		 
		 
		 
		 
		
	});	
	
	initTabla();
}

var tabla;
function initTabla() {
	
	var paramValue = $("#txtValor").val();
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
            dataSrc : 'lista'
        },
        "language" : dtLanguage,
        "columns" : columns
    });

}
