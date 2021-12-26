<div class="page-content">
   <div class="container-fluid">
      <div class="row">
         <div class="col-12">
            <div class="card">
               <div class="card-header">
                  <div class="row">
                     <div class="col-md-6">
                        <h4 class="mt-2 header-title">Documents</h4>
                     </div>
                     <div class="col-md-6">
                        <div class="float-right">
                           <a class="btn btn-primary waves-effect waves-light" data-toggle="modal" data-animation="bounce" data-target=".bs-example-modal-lg"><i class="mdi mdi-cloud-upload mr-2"></i>Upload Documents</a>
                        </div>
                     </div>
                  </div>
               </div>
                <form class="needs-validation-document-filter" id="document-fiter-form" novalidate>
              <div class="card-body">
               
               
                  <div class="row mb-3 page-header">
                     <div class="col-md-4">
                        <div class="form-group row">
                           <label class="col-sm-4 col-form-label text-right" >Project Name</label>
                           <div class="col-sm-8">
                              <select class="form-control" data-placeholder="choose option" id="documentProjectName" required>
                              <option>Choose option</option>
                              </select>
                              	<div class="invalid-feedback">Please select Project</div>
                           </div>
                        </div>
                     </div>
                     <div class="col-md-4">
                        <div class="form-group row">
                           <label class="col-sm-4 col-form-label text-right">Folder Name</label>
                           <div class="col-sm-8">
                              <select class="form-control" data-placeholder="choose option" id="documentFolderList" required>
                              </select>
                              	<div class="invalid-feedback">Please select Folder</div>
                           </div>
                        </div>
                     </div>
                     <div class="col-md-4">
                        <button type="button" class="btn btn-secondary waves-effect waves-light mr-2" id="documentClearButton">Clear</button>
                        <button type="submit" class="btn btn-primary waves-effect waves-light">Search</button>
                    	
                     </div>
                  </div>
                 
               </div>
                </form>
               <div class="card-body">
                  <table id="document-list-dataTable" class="table table-bordered table-striped dt-responsive nowrap" style="border-collapse: collapse; border-spacing: 0; width: 100%;">
                     <thead>
                        <tr>
                           <th data-priority="2">S.No</th>
                           <th>Document Name</th>
                           <th>Uploaded Date</th>
                           <th data-priority="1">Actions</th>
                        </tr>
                     </thead>
                  </table>
               </div>
            </div>
         </div>
         <!-- end col -->
      </div>
      <!-- end row -->
   </div>
</div>

   <div class="row">
      <div class="col-md-6 col-lg-3">
         <div class="card">
            <div class="card-body">
               <!--  Modal content for the above example -->
               <div id="upload-folder-modal" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                  <div class="modal-dialog modal-lg">
                     <div class="modal-content">
                     <form class="needs-validation-upload-form"  id="upload-document-form" novalidate >
                        <div class="modal-header">
                           <h5 class="modal-title mt-0" id="myLargeModalLabel">Upload Documents</h5>
                           <button type="button" class="close" data-dismiss="modal" aria-hidden="true" id="upladDocumentclose">×</button>
                        </div>
                        <div class="modal-body">
                           <div class="row">
                              <div class="col-md-4">
                                 <div class="form-group">
                                    <label for="exampleFormControlSelect1">Project Name</label>
                                    <select class="form-control" data-placeholder="choose option" id="uploadDocumentProjectList" required>
                                   
                                    </select>
                                    <div class="invalid-feedback">Please enter Project name</div>
                                 </div>
                              </div>
                              <div class="col-md-4">
                                 <div class="form-group">
                                    <label for="exampleFormControlSelect1">Folder Name</label>
                                    <select class="form-control" data-placeholder="choose option" id="uploadDocumentFolderList" required>
                                    
                                    </select>
                                    <div class="invalid-feedback">Please enter folder name</div>
                                 </div>
                              </div>
                              <div class="col-md-4">
                                 <label for="exampleFormControlSelect1">Upload Document  [ 	< 20 MB]</label>
                                 <div class="custom-file mb-4">
                                    <input type="file" class="custom-file-input" id="documentFileUpload" multiple  required>
                                    <label class="custom-file-label" for="customFile">Choose file</label>
                                 </div>
                                 <div class="invalid-feedback">Please enter name</div>
                              </div>
                           </div>
                        </div>
                        <div class="modal-footer">
                           <button type="button" class="btn btn-secondary waves-effect" data-dismiss="modal" id="uploadDocumentCloseButton">Close</button>
                           <button type="submit" class="btn btn-primary waves-effect waves-light">Upload</button>
                        </div>
                        </form>
                     </div>
                     <!-- /.modal-content -->
                  </div>
                  <!-- /.modal-dialog -->
               </div>
               <!-- /.modal -->
            </div>
            <!--end card-body-->
         </div>
         <!--end card-->
      </div>
   </div>
</div>
</div>
<script type="text/Javascript" src="${pageContext.request.contextPath}/functionJs/documentFunction.js"></script>