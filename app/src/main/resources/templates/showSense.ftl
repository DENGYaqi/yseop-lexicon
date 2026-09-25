<!DOCTYPE html>
<html>
    <head>
        <title>Senses</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="/css/style.css" />
        </head>
    <body>
      <div style="vertical-align:top; text-align: center; width : 100%; height : auto;">
        <h2>Sense</h2>
         <table align = "center" border="1" cellpadding="3" cellspacing="0" style="width: 60%;margin:auto">
            <tr>
               <th>Id</th>
               <th>Score</th>
               <th>Concept</th>
               <th>Word</th>
               <th>Origin</th>
            </tr>
            <tr>
                    <td>${sense.getId()!}</td>
                    <td>${sense.getScore()!}</td>
                    <td>${sense.getConcept()!}</td>
                    <td>${sense.getWord()!}</td>
                    <td>${sense.getOrigin()!}</td>
                    </tr>
                    </table>
        <br><br>
        </div>
    	<a href="/"> <p style="text-align:center">Home page </p></a>
    </body>
</html>