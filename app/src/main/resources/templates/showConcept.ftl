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
        <h2>Concept</h2>
         <table align = "center" border="1" cellpadding="3" cellspacing="0" style="width: 80%;margin:auto">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Def</th>
                <th>Usages</th>
                <th>Origin</th>
                <th>Semclass</th>
                <th>Disabled</th>
                <th>Update this concept</th>
            </tr>
            <tr>
                    <td>${concept.getId()!}</td>
                    <td>${concept.getName()!}</td>
                    <td>${concept.getDef()!}</td>
                    <td>${concept.getUsages()!}</td>
                    <td>${concept.getOrigin()!}</td>
                    <td>${concept.getSemclass()!}</td>
                    <td>${concept.getDisabled()?string("yse", "no")}</td>
                    <!--------Need creat a fonction of updateLeffSem --------->
                    <td><a href = "../updateConcept/${concept.id!}">${concept.id!}</a></td>
                    </tr>
          </table>
          
        <h2>Word of Concept</h2>
         <table align = "center" border="1" cellpadding="3" cellspacing="0" style="width: 80%;margin:auto">
            <tr>
                <th>Id and Name</th>
            </tr>
            <#list words as word>
            <tr>
			<!-- Link to concept dependence -->
			<!-- Cause if dont add ../../ relative path. URL go to add localhost:8080/concept/word/id.
				 And this path can not match correctely -->
			<td><a href="../word/${word.id!}">${word.id!} ${word.lemma!}</a></td>
            </tr>
            </#list>
          </table>
         <!-----------------HERE NEED A UPDATE NOT ADD --------------> 
	   <a href="/addSense"> <p style="text-align:center"> Link a word with this concept </p> </a>
       <h2>Relation with other concept</h2>
         <table align = "center" border="1" cellpadding="3" cellspacing="0" style="width: 80%;margin:auto">
            <tr>
                <th>Relation</th>
            </tr>
            <#list rels as rel>
            <tr>
			<!-- Link to concept dependence -->
			<!-- Cause if dont add ../../ relative path. URL go to add localhost:8080/concept/word/id.
				 And this path can not match correctely -->
			<td>has relation : <a href="../rel/${rel.name!}">${rel.name!}</a> with <a href="../concept/${rel.target!}">${rel.target!}</a></td>
            </tr>
            </#list>
          </table>
	      <a href="/addRelation"> <p style="text-align:center"> Add Relation of this concept </p> </a>
          </div>
        <br><br>
    	<a href="/"> <p style="text-align:center">Home page</p></a>
    </body>
</html>