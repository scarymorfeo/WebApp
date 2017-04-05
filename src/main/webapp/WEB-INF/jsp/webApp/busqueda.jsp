<script
	src="${pageContext.request.contextPath}/resources/js/busqueda.js"
	type="text/javascript"></script>
<div id="box_wrap">

	<section id="middle" class="">

		<div class="container">

			<div class="row">
				<div class="col-sm-12 text-center">
					<h2 class="block-header">Busqueda</h2>
				</div>
			</div>
			<div class="row">

				<div class="col-sm-12">
				
					<div class="col-sm-8">
					
						<div class="form-horizontal" role="form">
	
							<div class="form-group">
								<label for="txtValor" class="col-md-3 control-label">Nombre Completo</label>
								<div class="col-md-9">
									<input type="text" aria-required="true" size="30" value="" name="txtValor" id="txtValor" class="form-control">
								</div>
							</div>
	
							<div class="form-group">
								<label for="txtValorRfc" class="col-md-3 control-label">RFC</label>
								<div class="col-md-9">
									<input type="text" aria-required="true" size="13" value="" name="txtValorRfc" id="txtValorRfc" class="form-control">
								</div>
							</div>
	
						</div>					
					
					</div>
					<div class="col-sm-4">
					
						<p class="contact-form-submit text-center vertical-margin-20">

							<button type="button" class="btn btn-primary" id="btnBuscar"
								name="btnBuscar">
								<i class="fa fa-search" aria-hidden="true"></i> Buscar

							</button>

						</p>					
					
					</div>
					





				</div>



			</div>

			<div class="row">

				<table id="tabla-busqueda"
					class="display table table-striped table-hover table-condensed"
					width="100%">

					<thead>
						<tr>
							<th>NumPer</th>
							<th>Nombre</th>
							<th>RFC</th>
							<th>SCORE</th>
						</tr>
					</thead>

				</table>

			</div>

		</div>
	</section>


	<section id="copyright" class="dark_section">
		<div class="container">
			<div class="row">

				<div class="col-sm-6">
					<p>
						&copy; Copyright 2017.<a href="#" target="_blank"><img
							src="${pageContext.request.contextPath}/resources/img/flama.png"
							style="width: 100px;" border="0"></a>
					</p>
				</div>

				<div class="col-sm-6">
					<!--div class="block widget_nav_menu">
						<ul class="nav menu">
							<li><a href="home.html">Home</a></li>
						</ul>
					</div-->
				</div>

			</div>
		</div>
	</section>



	<!-- Modal tracking-->
	<div id="modal-update-user" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">
						Actualizar Usuario <span id="headerProjectTrackingModal"></span>
					</h4>
				</div>
				<div class="modal-body">

					<input type="hidden" id="hdnIdUser" />



					<form id="actualizar-usuario-form" class="contact-form"
						data-toggle="validator">
						<p class="contact-form-name">
							<label for="upd-name">Nombre <span class="required">*</span></label>
							<input type="text" aria-required="true" size="30" value=""
								name="upd-name" id="upd-name" class="form-control"
								placeholder="Nombre">
						</p>
						<p class="contact-form-email">
							<label for="upd-email">Correo <span class="required">*</span></label>
							<input type="email" aria-required="true" size="30" value=""
								name="upd-email" id="upd-email" class="form-control"
								placeholder="Correo electronico">
						</p>

					</form>




				</div>
				<div class="modal-footer">
					<button class="btn btn-primary theme_btn" id='btnUpdUser'
						title='Actualizar usuario'>
						Actualizar&nbsp;<i class="fa fa-refresh"></i>
					</button>

				</div>
			</div>

		</div>
	</div>



</div>
<!-- EOF #box_wrap -->



