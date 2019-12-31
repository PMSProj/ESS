<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%String st=" " ;%>
</head>
<body>
	<section class="content">
		<div class="row">
			<div class="col-sm-12">
				<div class="box box-success">
					<div class="box-header">
						<h3 class="box-title">Upload Employee SOA</h3>
					</div>
					<form name=frm enctype="multipart/form-data"
						action="${pageContext.request.ContextPath}/upload" method="post">
						<div class="row">
							<div class="col-sm-8 col-sm-offset-2">
								<p style="color: DodgerBlue">[Please see the format sample
									before uploading the excel sheet ]</p>
								<div class="form-group">
									<label>Select File </label> <input type="file" name="Exceltxt"
										id="ExcelTxt" class="span3" />
								</div>
								<input type="hidden" name="filestype" value="xls"
									class="form-control" />
							</div>
							<div class="row">
								<div class="col-sm-12">
									<div class="form-group">
										<label>Sheet Name</label> <input type="text"
											name="Sheettxt" value="<%=st%>" class="form-control"
											maxlength="20" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12" align="center">
									<input type="Submit" name="UploadCmd" class="btn btn-success" value="Upload" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12"><</div>

							</div>
					</form>
                  <h1>UploadStatus</h1>
                  <h2>Message:${message }</h2>


				</div>
			</div>

		</div>
	</section>
</body>
</html>