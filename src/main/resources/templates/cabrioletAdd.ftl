<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<style>
    * {
        background-image: url(https://hevcars.com.ua/wp-content/uploads/2017/08/mercedes-benz-ev-vision-mercedes-maybach-6-cabriolet-hevcars-01.jpg);
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-size: cover;);
    }
</style>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="cabriolet" action="" method="POST">
     Model:
    <br>
    <@spring.formInput "cabrioletForm.model" "" "text"/>
    <br>
    Brand:
    <br>
    <@spring.formInput "cabrioletForm.brand", "", "text"/>
    <br>
    Producing country:
    <br>
    <@spring.formInput "cabrioletForm.producingCountry", "", "text"/>
    <br>
    Graduation year:
    <br>
    <@spring.formInput "cabrioletForm.graduationYear", "", "text"/>

    <input type="submit" value="Create"/>
</form>

</body>
</html>