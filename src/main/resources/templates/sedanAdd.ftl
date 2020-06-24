<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<style>
    * {
        background-image: url(https://s0.rbk.ru/v6_top_pics/media/img/7/45/755712083492457.jpg);
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
<form name="sedan" action="" method="POST">
    Model:
    <br>
    <@spring.formInput "sedanForm.model" "" "text"/>
    <br>
    Brand:
    <br>
    <@spring.formInput "sedanForm.brand", "", "text"/>
    <br>
    Producing country :
    <br>
    <@spring.formInput "sedanForm.producingCountry", "", "text"/>
    <br>
    Graduation year:
    <br>
    <@spring.formInput "sedanForm.graduationYear", "", "text"/>
    <br>
    <input type="submit" value="Create"/>
</form>

</body>
</html>