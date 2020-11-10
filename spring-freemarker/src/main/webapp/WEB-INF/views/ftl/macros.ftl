<#macro empTable empList>
<#list empList as emp>
	  	<tr>
	  	
	  	<td>${emp.empId}</td>
	  	
	  	<td>${emp.name?cap_first}</td>
	  	
	  	<td>${emp.salary}</td>
        <td>
            <span id="clickableAwesomeFont"><i class="fa fa-pencil-square-o" aria-hidden=" true"
             onclick="httpCall('/spring-freemarker/${emp.empId?replace(",", "")}','GET');show();"></i></span>
              
                  &nbsp;&nbsp;&nbsp;&nbsp;
            
             <span id="clickableAwesomeFont"><i class="fa fa-trash" aria-hidden="true" 
             onclick="httpCall('/spring-freemarker/delete/${emp.empId?replace(",", "")}','DELETE');location.reload()"></i></span>
            
        </td>
	  	</tr>
        </#list>
</#macro>