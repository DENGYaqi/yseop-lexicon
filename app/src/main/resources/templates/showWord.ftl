<!DOCTYPE html>
<html>
    <head>
        <title>Words</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="/css/style.css" />
        </head>
    <body>
      <div style="vertical-align:top; text-align: center; width : 100%; height : auto;">
         <table>
			<!-- Show All words -->
            <#list words as word>
        		<h2>Word</h2>
         	<table align = "center" border="1" cellpadding="3" cellspacing="0" style="width: 80%;margin:auto">
 			<tr>
                <th>Id</th>
                <th>cpos</th>
                <th>pos</th>
                <th>Lemma</th>
                <th>lang</th>
                <th>infl</th>
                <th>tag</th>
                <th>modal</th>
                <th>neg</th>
                <th>disabled</th>
                <th>origin</th>
                <th>update this word </th>
            	</tr>
                <tr>
                    <td>${word.id}</td>
                    <td>${word.cpos!}</td>
                    <td>${word.pos!}</td>
                    <td>${word.lemma!}</td>
                    <td>${word.lang!}</td>
                    <td>${word.infl!}</td>
                    <td>${word.tag!}</td>
                    <td>${word.modal!}</td>
                    <td>${word.neg!}</td>
                    <td>${word.disabled?string("yse", "no")}</td>
                    <td>${word.origin!}</td>
                    <!--------Need creat a fonction of updateWord --------->
                    <td><a href = "../updateWord/${word.id!}">${word.id!}</a></td>
                   </table> 
                   
                <!--------------------------------------------------------------------->
				<!---------------------- Show All senses ------------------------------>
                <!--------------------------------------------------------------------->
         		<table align = "center" border="1" cellpadding="3" cellspacing="0" style="width: 80%;margin:auto">
                  <br> 
        			<h2>Sense</h2>
                    <tr>
                   	<th> ID </th>
                   	<th> Word id </th>
                   	<th> Score </th>
                   	<th> concept </th>
                   	<th> domain </th>
                   	<th> origin </th>
                   	<th> update this sense </th>
                   	</tr>
						<#list word.senses! as sense>
                    	<tr>
						<!-- Link to sense dependence -->
				   	 	<td><a href="../sense/${sense.id}">${sense.id!}</a></td>
                    		<td>${sense.word}</td>
                    		<td>${sense.score!}</td>
							<!-- Link to concept dependence -->
				   	 		<td><a href="../concept/${sense.concept}">${sense.concept}</a></td>
                    		<td>${sense.domain!}</td>
                    		<td>${sense.origin!}</td>
                    		<!--------Need creat a fonction of updateSense --------->
                    		<td><a href = "../updateSense/${sense.id!}">${sense.id!}</a></td>
                    	</tr>
                    	</#list>
                    	</table>
                   	
                    <a href="/addSense"> <p style="text-align:center"> Add Sense of this word </p> </a>
                    	
					<!-- Show All wordForms -->
         			<table align = "center" border="1" cellpadding="3" cellspacing="0" style="width: 80%;margin:auto">
                   	<br> 
        			<h2>Word Form</h2>
                    <tr>                   	
                    <th> id </th>
                    <th> word id</th>
                   	<th> disabled </th>
                   	<th> form </th>
                   	<th> morph </th>
                   	<th> lefffPos </th>
                   	<th> update this word form </th>
                   	</tr>
                   	<#list word.wordForm! as wf>
                   	<tr>
                   	<td>${wf.id!}</td>
                    	<td>${wf.wordId!}</td>
                    	<td>${wf.disabled?string("yes", "no")!}</td>
                    	<td>${wf.form!}</td>
                    	<td>${wf.morph!}</td>
                    	<td>${wf.lefffpos!}</td>
                    	<!--------Need creat a fonction of updateWordForm --------->
                    	<td><a href = "../updateWordForm/${wf.id!}">${wf.id!}</a></td>
                    	</tr>
                    </#list>
                    </table>
                    
                    <a href="/addWordForm"> <p style="text-align:center"> Add Word Form of this word </p> </a>
					<!-- Show All leffSems -->
         			<table align = "center" border="1" cellpadding="3" cellspacing="0" style="width: 80%;margin:auto">
                   	<br> 
        				<h2>Leff Sem</h2>
                    <tr>                   	
                    <th> id </th>
                   	<th> form </th>
                   	<th> pred </th>
                   	<th> fram </th>
                   	<th> tag </th>
                   	<th> syntax </th>
                   	<th> wordId </th>
                   	<th> update this leffSem </th>
                   	</tr>
                    
                    <#list word.leffSems! as ls>
                    	<tr>
                    	<td>${ls.id}</td>
                    	<td>${ls.form!}</td>
                    	<td>${ls.pred!}</td>
                    	<td>${ls.fram!}</td>
                    	<td>${ls.tag!}</td>
                    	<td>${ls.syntax!}</td>
                    	<td>${ls.wordId!}</td>
                    	<!--------Need creat a fonction of updateLeffSem --------->
                    	<td><a href = "../updateLeffSem/${ls.id!}">${ls.id!}</a></td>
                    	</tr>
                    </#list>
                    </table>
                </tr>
            </#list>
        </table>
		<a href="/addLeffSem"> <p style="text-align:center"> Add LeffSem of this word </p> </a>
        <br><br>
        </div>
    	<a href="/"> <p style="text-align:center">Home page</p></a>
    </body>
</html>