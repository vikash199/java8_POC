<div class="page-content">
   <div class="container-fluid">
      <div class="row">
         <div class="col-12">
            <div class="card">
               <div class="card-header">
                  <div class="row">
                     <div class="col-md-6">
                        <h4 class="mt-2 header-title">Projects</h4>
                     </div>
                     <div class="col-md-6">
                        <div class="float-right">
                           <a  class="btn btn-primary waves-effect waves-light" data-toggle="modal" data-animation="bounce" data-target=".bs-example-modal-lg"><i class="mdi mdi-plus mr-2"></i>Create</a>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="card-body">
                  <table id="project-list-dataTables" class="table table-bordered table-striped dt-responsive nowrap" style="border-collapse: collapse; border-spacing: 0; width: 100%;">
                     <thead>
                        <tr>
                           <th>S.No</th>
                           <th>Project Name</th>
                           <th>Folders</th>
                           <th>Actions</th>
                        </tr>
                     </thead>
                  </table>
               </div>
            </div>
         </div>
         <!-- end col -->
      </div>
   </div>
</div>
</div></div>
<!-- end row -->

<div id="create-project-model" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" style="display: none;">
   <div class="modal-dialog modal-lg">
      <div class="modal-content">
      <form class="needs-validation-project-cration" id="create-project-form" novalidate>
         <div class="modal-header">
            <h5 class="modal-title mt-0" id="myLargeModalLabel">Create Project</h5>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
         </div>
         <div class="modal-body">
            <div class="row">
               <div class="col-md-6">
                  <div class="form-group">
                     <label for="exampleInputEmail1">Project Name</label>
                     <input type="text" class="form-control" id="createProjectField"  placeholder="Project Name" required>
                     <div class="invalid-feedback">Please enter projectName</div>
                  </div>
               </div>
               <div class="col-md-6">
                  <label for="name">Select Folder</label>
                  <select id="projectFolderList" class="form-control multiselect-select-all" multiple="multiple" required>
                 
                    
                  </select>
                  <div class="small text-danger" id="fromUsersError">Please select folders/s</div>
	               <div class="invalid-feedback">Please select folders</div>
               </div>
            </div>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-secondary waves-effect" data-dismiss="modal">Close</button>
            <button type="submit" class="btn btn-primary waves-effect waves-light">Create</button>
         </div>
         </form>
      </div>
      <!-- /.modal-content -->
   </div>
   <!-- /.modal-dialog -->
</div>
<div class="modal fade bs-example-modal-lg-folder" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
   <div class="modal-dialog modal-lg">
      <div class="modal-content">
         <div class="modal-header">
            <h5 class="modal-title mt-0" id="myLargeModalLabel">Add Folder</h5>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
         </div>
         <div class="modal-body">
            <div class="row">
               <div class="col-md-6">
                  <div class="form-group">
                     <label for="exampleInputEmail1">Folder Name</label>
                     <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="">
                  </div>
               </div>
            </div>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-secondary waves-effect" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary waves-effect waves-light">Create</button>
         </div>
      </div>
      <!-- /.modal-content -->
   </div>
   <!-- /.modal-dialog -->
</div>
<div class="modal fade bs-example-modal-lg-edit" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
   <div class="modal-dialog modal-lg">
      <div class="modal-content">
          <form class="needs-validation-edit-project-cration" id="edit-project-form" novalidate>
       
         <div class="modal-header">
            <h5 class="modal-title mt-0" id="myLargeModalLabel">Edit Project</h5>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
         </div>
         <div class="modal-body">
            <div class="row">
               <div class="col-md-6">
                  <div class="form-group">
                     <label for="exampleInputEmail1">Project Name</label>
                     <input type="text" class="form-control" id="editProjectName" placeholder="Project Name" required>
                      <div class="invalid-feedback">Please select Project</div>
                  </div>
               </div>
               <div class="col-md-6">
                  <label for="editProjectFolderList">folder</label>
                  <select id="editProjectFolderList" class="form-control multiselect-select-all" multiple="multiple" required>
                   
                  
                   
                  </select>
                  <div class="small text-danger" id="editfromUsersError">Please select folders/s</div>
	               <div class="invalid-feedback">Please select folder</div>
               </div>
            </div>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-secondary waves-effect" data-dismiss="modal">Cancel</button>
            <button type="submit" class="btn btn-primary waves-effect waves-light">Update</button>
         </div>
         </form>
      </div>
      <!-- /.modal-content -->
   </div>
   <!-- /.modal-dialog -->
</div>
<script type="text/Javascript" src="${pageContext.request.contextPath}/functionJs/indexFunction.js"></script>