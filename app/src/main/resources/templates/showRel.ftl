<!DOCTYPE html>
<html>
    <head>
        <title>Relations</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="/css/style.css" />
        </head>
    <body>
      <div style="vertical-align:top; text-align: center; width : 100%; height : auto;">
        <h2>Relation</h2>
         <table align = "center" border="1" cellpadding="3" cellspacing="0" style="width: 60%;margin:auto">
            <tr>
               <th>Primary Key</th>
               <th>Name</th>
               <th>Source Concept</th>
               <th>Target Concept</th>
               <th>Domain</th>
               <th>Description</th>
               <th>Disabled</th>
               <th>Origin</th>
            </tr>

            <#list rels as rel>
            <tr>
                    <td>${rel.getPrimaryKey().toString()!}</td>
                    <td>${rel.getName()!}</td>
                    <td>${rel.getSource()!}</td>
                    <td>${rel.getTarget()!}</td>
                    <td>${rel.getDomain()!}</td>
                    <td>${rel.getDescription()!}</td>
                    <td>${rel.getDisabled()?string("yes", "no")}</td>
                    <td>${rel.getOrigin()!}</td>
                    </tr>
                    </#list>
                    </table>
        <br><br>
        </div>
    	<a href="/"> <p style="text-align:center">Home page</p></a>
    </body>
</html>