<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Car body type list</h3>
<div>
    <fieldset>
        <form name="search" action="" method="POST">
            <div class="search">
                 Car body type:<@spring.formInput "searchForm.string" "" "text"/>
                <br>
            </div>
            <input type="submit" value="Search"/>
        </form>
    </fieldset>
</div>
<br>

<a href="/" type="button" class="btn btn-light" style="float:left; margin-top:5px;"><i class="fa fa-chevron-circle-left"></i>Back to home page</a>

<a href="/web/carBodyType/create" type="button" class="btn btn-light" style="float:right; margin-top:5px;"><i class="fa fa-plus-square-o"></i>Add new coup</a>

<div>
    <table class="table table-sm table-dark">
        <tr class="table-success">
            <th>ID</th>
            <th>Type<a href="/web/carBodyType/list/sorted" type="button" class="btn btn-outline-light">
                                                             <i class="fa fa-sort-alpha-asc"></i></a> <a href="/web/carBodyType/list" type="button" class="btn btn-outline-light">
                                                             <i class="fa fa-undo"></i>Undo sort</a></th>
            <th>Producer</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list carBodyType as carBodyType>
            <tr>
                <td>${carBodyType.id}</td>
                <td>${carBodyType.type}</td>
                <td>${carBodyType.producer}</td>
                <td><a href="/web/carBodyType/delete/${carBodyType.id}"><button>Delete</button></a></td>
                 <td><a href="/web/carBodyType/edit/${carBodyType.id}"><button>Edit</button></a></td>
            </tr>
        </#list>
    </table>
</div>

</body>
</html>