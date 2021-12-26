<div class="page-content">
   <div class="container-fluid">
      <div class="row">
         <div class="col-12">
            <div class="card">
               <div class="card-header">
                  <div class="row">
                     <div class="col-md-6">
                        <h4 class="mt-2 header-title">Folder</h4>
                     </div>
                     <div class="col-md-6">
                        <div class="float-right">
                           <a class="btn btn-primary waves-effect waves-light" data-toggle="modal" data-animation="bounce" data-target=".bs-example-modal-lg"><i class="mdi mdi-plus mr-2"></i>Create Folder</a>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="card-body">
                  <table id="folder-list-dataTable" class="table table-bordered table-striped dt-responsive nowrap" style="border-collapse: collapse; border-spacing: 0; width: 100%;">
                     <thead>
                        <tr>
                           <th>S.No</th>
                           <th>Folder Name</th>
                           <th>Created Date</th>
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
</div></div>
<form  class="needs-validation-folder-cration" id="create-folder-form" novalidate >

<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
   <div class="modal-dialog modal-lg">
      <div class="modal-content">
         <div class="modal-header">
            <h5 class="modal-title mt-0" id="myLargeModalLabel">Create Folder</h5>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true" id="closeCreateFolderEvent">×</button>
         </div>
         <div class="modal-body">
            <div class="row">
               <div class="col-md-6">
                  <div class="form-group">
                     <label for="exampleInputEmail1">Folder Name</label>
                     <input type="text" class="form-control" id="createFolderName" placeholder="Folder Name" required>
                     <div class="invalid-feedback">Please enter folderName</div>
                  </div>
               </div>
            </div>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-secondary waves-effect" data-dismiss="modal" id="folderCreateCloseButton">Close</button>
            <button type="submit" class="btn btn-primary waves-effect waves-light">Create</button>
         </div>
      </div>
      <!-- /.modal-content -->
   </div>
</div>
</form>
<script type="text/Javascript" src="${pageContext.request.contextPath}/functionJs/folderFunction.js"></script>