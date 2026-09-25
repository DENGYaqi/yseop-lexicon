<!DOCTYPE html>
<html>
    <head>
        <title>Concepts</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="/css/style.css" />
        </head>
    <body>
      <div style="vertical-align:top; text-align: center; width : 100%; height : auto;">
        <h2>Domain</h2>
         <table align = "center" border="1" cellpadding="3" cellspacing="0" style="width: 80%;margin:auto">
            <tr>
                <th>Id</th>
                <th>Value</th>
                <th>Update this Domain</th>
            </tr>
            <tr>
                    <td>${domain.getId()!}</td>
                    <td>${domain.getValue()!}</td>
                    <!--------Need creat a fonction of updateDomain --------->
                    <td><a href = "../updateDomain/${domain.id!}">${domain.id!}</a></td>
                    </tr>
          </table>
          </div>
        <br><br>
    	<a href="/"> <p style="text-align:center">Home page</p></a>
    </body>
</html>