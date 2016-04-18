<form:form
  action="${pageContext.request.contextPath}/upload" method="post"
  modelAttribute="filesUploadForm" enctype="multipart/form-data">
  <table>
    <tr>
      <th width="35%">File to upload</th>
      <td width="65%">
        <form:input type="file" path="fileUploadForms[0].file" />
        <form:errors path="fileUploadForms[0].file" />
      </td>
    </tr>
    <tr>
      <th width="35%">Description</th>
      <td width="65%">
        <form:input path="fileUploadForms[0].description" />
        <form:errors  path="fileUploadForms[0].description" />
      </td>
    </tr>
  </table>
  <table>
    <tr>
      <th width="35%">File to upload</th>
      <td width="65%">
        <form:input type="file" path="fileUploadForms[1].file" />
        <form:errors path="fileUploadForms[1].file" />
      </td>
    </tr>
    <tr>
      <th width="35%">Description</th>
      <td width="65%">
        <form:input path="fileUploadForms[1].description" />
        <form:errors path="fileUploadForms[1].description" />
      </td>
    </tr>
    <tr>
        <th>Comment</th>
        <td>
            <form:input path="comment"/>
            <form:errors path="comment" />
        </td>
    </tr>
  </table>
  <div>
    <form:button>Upload</form:button>
  </div>
</form:form>
