$(document).ready(function() {
	handler();
	//alert("xxxxxxxxxxxxxxxxx");
});


function handler() {
	
	$("#btnBuscar").click(function() {
		 var paramValue = $("#txtValor").val();
		 var paramValue2 = $("#txtValorRfc").val();
		 
		 $.ajax({
	            url : 'consultarBusqueda.json',
	            type : 'GET',
	            dataType : 'json',
	            data:{
	            	param:paramValue,param2:paramValue2
	            },
	            success : function(respuesta) {
	            	
	            	if (respuesta.lista.length === 0 ){
	            		tabla.clear().draw();
	            	}else {     	
	            	
	            	tabla.destroy();
	                assignToEventsColumns(respuesta.lista);
	            	}
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
	var paramValue2 = $("#txtValorRfc").val();
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
