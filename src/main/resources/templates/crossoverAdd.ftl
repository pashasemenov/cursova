<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<style>
    * {
        background-image: url(https://cdnimg.rg.ru/img/content/178/36/35/9999_d_850.jpg);
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-size: cover;
    }
</style>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="crossover" action="" method="POST">
     Model:
    <br>
    <@spring.formInput "crossoverForm.model" "" "text"/>
    <br>
     Brand:
    <br>
    <@spring.formInput "crossoverForm.brand", "", "text"/>
    <br>
     Producing country :
    <br>
    <@spring.formInput "crossoverForm.producingCountry", "", "text"/>
    <br>
     Graduation year:
    <br>
    <@spring.formInput "crossoverForm.graduationYear", "", "text"/>
    <br>
    <input type="submit" value="Create"/>
</form>

</body>
</html>