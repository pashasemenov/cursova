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
<form name="universal" action="" method="POST">
    Model:
    <br>
    <@spring.formInput "universalForm.model" "" "text"/>
    <br>
    Brand:
    <br>
    <@spring.formInput "universalForm.brand", "", "text"/>
    <br>
    Producing country :
    <br>
    <@spring.formInput "universalForm.producingCountry", "", "text"/>
    <br>
    Graduation year:
    <br>
    <@spring.formInput "universalForm.graduationYear", "", "text"/>
    <br>
    <input type="submit" value="Create"/>
</form>

</body>
</html>