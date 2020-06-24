<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
     <link rel="stylesheet" href="css/style1.css" type="text/css">
     <link href="https://fonts.googleapis.com/css?family=Cuprum" rel="stylesheet">
</head>
<body>
<h3>Coupe list</h3>
<br>
<div>
    <fieldset>
        <form name="search" action="" method="POST">
            <div class="search">
                Coupe model:<@spring.formInput "searchForm.string" "" "text"/>
                <br>
            </div>
            <input type="submit" value="Search"/>
        </form>
    </fieldset>
</div>
<br>

<a href="/" type="button" class="btn btn-light" style="float:left; margin-top:5px;"><i class="fa fa-chevron-circle-left"></i>Back to home page</a>

<a href="/web/coupe/create" type="button" class="btn btn-light" style="float:right; margin-top:5px;"><i class="fa fa-plus-square-o"></i>Add new coup</a>

<br>

<div>
    <table class="table table-sm table-dark">
        <tr class="table-success">
            <th>ID</th>
            <th>Model<a href="/web/coupe/list/sorted" type="button" class="btn btn-outline-light">
                                         <i class="fa fa-sort-alpha-asc"></i></a> <a href="/web/coupe/list" type="button" class="btn btn-outline-light">
                                         <i class="fa fa-undo"></i>Undo sort</a></th>
            <th>Brand</th>
            <th>Producing country</th>
            <th>Graduation year</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list coupe as coupe>
            <tr>
                <td>${coupe.id}</td>
                <td>${coupe.model}</td>
                <td>${coupe.brand}</td>
                <td>${coupe.producingCountry}</td>
                <td>${coupe.graduationYear}</td>
                <td><a href="/web/coupe/delete/${coupe.id}"><button>Delete</button></a></td>
                <td><a href="/web/coupe/edit/${coupe.id}"><button>Edit</button></a></td>
            </tr>
        </#list>
    </table>
</div>

</body>
</html>