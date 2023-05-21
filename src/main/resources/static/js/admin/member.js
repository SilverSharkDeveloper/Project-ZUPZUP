$(document).ready(function(){
    let text = "";
    members.forEach(user => {
        text+= `
        <tr>
          <td class = "inputCheckBoxBtn"><input class="inputCheckBox"type="checkbox"></td>
                <td>${user.id}</td>
                <td>${user.userIdentification}</td>
                <td>${user.userNickName}</td>  
                <td>${user.userName}</td>
                <td>${user.userRole}</td>
                <td>${user.userTissue}</td>
                <td>${user.userCreatedDate}</td>
                <td></td>
            </tr>
        `
    });

    $('.userTable tbody').html(text);
})