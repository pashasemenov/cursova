<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<style>
    * {
        background-color: lightpink;
    }
</style>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="employees" action="" method="POST">
    Surname:
    <br>
    <@spring.formInput "employeesForm.surname" "" "text"/>
    <br>
    Name:
    <br>
    <@spring.formInput "employeesForm.name", "", "text"/>
    <br>
     Patronymic:
    <br>
    <@spring.formInput "employeesForm.patronymic", "", "text"/>
    <br>
    Position:
    <br>
    <@spring.formInput "employeesForm.position", "", "text"/>
    <br>
    Address:
    <br>
    <@spring.formInput "employeesForm.address", "", "text"/>
    <br>
    Phone:
    <br>
    <@spring.formInput "employeesForm.phone", "", "text"/>
    <br>
    <input type="submit" value="Create"/>
</form>

</body>
</html>