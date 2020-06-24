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
<form name="customers" action="" method="POST">
     Clients name:
    <br>
    <@spring.formInput "customersForm.clientsName" "" "text"/>
    <br>
    Passport data:
    <br>
    <@spring.formInput "customersForm.passportData", "", "text"/>
    <br>
    Home address:
    <br>
    <@spring.formInput "customersForm.homeAddress", "", "text"/>
    <br>
    Phone:
    <br>
    <@spring.formInput "customersForm.phone", "", "text"/>
    <br>
    <input type="submit" value="Create"/>
</form>

</body>
</html>