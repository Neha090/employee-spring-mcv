create or replace PROCEDURE Create_employee(e_name varchar,sal NUMBER)
IS
e_id number;
max_id number;
BEGIN
SELECT NVL(MAX(empId),0) INTO max_id FROM employee;
e_id:=max_id+1;
   insert into EMPLOYEE(empId,name,salary)
   values(e_id,e_name,sal);
   commit;
   --DBMS_OUTPUT.PUT_line('Employee added');
  
EXCEPTION
   WHEN OTHERS THEN
      dbms_output.put_line( SQLERRM );
END;
/
create or replace PROCEDURE AllData(data out SYS_REFCURSOR)
AS
BEGIN
OPEN data FOR SELECT empId,name,salary FROM employee order by empId;
END;
/
create or replace PROCEDURE Update_employee(e_id NUMBER,e_name varchar,sal varchar)
IS
BEGIN
   update employee
   set NAME=e_name,salary=sal
   where empId=e_id;
   commit;
   --DBMS_OUTPUT.PUT_line('Employee name updated with id number'||' '||e_id);
  
EXCEPTION
   WHEN OTHERS THEN
      dbms_output.put_line( SQLERRM );
END;
/
create or replace PROCEDURE Delete_employee(e_id NUMBER)
IS
BEGIN
   delete from employee
   where empId=e_id;
   commit;
   --DBMS_OUTPUT.PUT_line('Employee deleted with id number'||' '||e_id);
  
EXCEPTION
   WHEN OTHERS THEN
      dbms_output.put_line( SQLERRM );
END;
/
