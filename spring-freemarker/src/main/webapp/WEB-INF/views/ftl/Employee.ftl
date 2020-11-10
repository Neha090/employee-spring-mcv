<#import "macros.ftl" as emp>


<#-- ${emp1.setName("neha")}
${emp1.getName()}  -->
<html>

<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<style>
.fa-trash , .fa-pencil-square-o {
    font-size:20px;
    color:orangered;
    text-align: center;
}

#output {
    border: 8px solid rgb(239, 246, 247);
    padding: 15px;
    width:50%;
    align-content: center;
    margin:auto;
}

#heading{
    font-size:20px;
}

*{
   color:rgb(77, 73, 73);
}

table {
    border-collapse: collapse;
    width: 100%;
    }

th,td {

    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
    text-align: center;
    }

#add{
    background-color:rgb(113, 200, 235);
    border-radius: 20px;
    color:white;
    float:right;
    font-size: 20px;
    border-color:rgb(113, 200, 235);
    box-shadow:rgb(113, 200, 235) ;
}

#empForm,#empupdate{
    color:grey;
    size:15px;
    text-align: center;
    display:none;
}

.input{
    background-color:rgb(113, 200, 235);
    color:white;
    font-size:15px;
    border-color:rgb(113, 200, 235);
}

#clickableAwesomeFont {
    cursor: pointer;
}
</style>


<script>
function show() {
    var x = document.getElementById("empForm");
    if (x.style.display == "block") { x.style.display = "none"; }
    else {
        x.style.display = "block";
    }
}

function httpCall(url,method){

	function reqListener () {
  		console.log(this.responseText);
	}
	var oReq = new XMLHttpRequest();
	oReq.addEventListener("load", reqListener);
	oReq.open(method, url);
	oReq.send();
}

</script>
</head>

<body>
<br><br>
    <div id="output"><br>
        <div id="heading">Employee <b>Details</b>
            <button type="button" id="add" onclick="show()">+Add New</button> 
            <br>
        </div>
        <br>
        <div id="empForm">
            <form name="emp" action="addEmployee/" method="put" >
                Name : <input type="text" name="name"  required><br><br>
                Salary :<input type="number" name="salary" ><br><br>
                <input type="submit" class="input" value="   Save   "/>
            </form>
        </div>
        <table>
        <tr>
        <th>EmpID</th>
        <th>Name</th>
        <th>Salary</th>
        <th>Actions</th>
        </tr>
        <@emp.empTable empList=model["empList"]/>
	    </table>
    </div>

</body>
</html>