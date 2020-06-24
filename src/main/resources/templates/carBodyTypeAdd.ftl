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
<form name="carBodyType" action="" method="POST">
    Type:
    <br>
    <@spring.formInput "carBodyTypeForm.type" "" "text"/>
    <br>
    Producer:
    <br>
    <@spring.formInput "carBodyTypeForm.producer", "", "text"/>
    <br>
    <input type="submit" value="Create"/>
</form>

</body>
</html>