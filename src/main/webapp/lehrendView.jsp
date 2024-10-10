<%--
  Created by IntelliJ IDEA.
  User: Mario
  Date: 10.10.2024
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <script type="module" src="js/script.js"></script>
    <script type="text/javascript" src="https://cdn.tiny.cloud/1/e0q0w4t1ep5f35kyxt999mzlm4ro2px179u580taztflq9sf/tinymce/7/tinymce.min.js" referrerpolicy="origin"></script>
    <link rel="stylesheet" href="css/style.css">
    <title>Aufagbe</title>
</head>
<body>
<textarea id="textarea"></textarea>
<div id="container">
    <div id="buttonleiste"></div>
    <div class="attribute-kategorie">
        <label for="bezeichnung">Bezeichnung</label>
        <label for="tag">Tag</label>
        <label for="farbe">Farbe</label>
        <!--<button id="btn-kategorie" onclick="toggleKategorieForm()">Erstelle Kategorie</button> -->
    </div>

    <div class="output-values">
        <p id="bezeichnung_output"></p>
        <p id="tag_output"></p>
        <p id="farbe_output"></p>
        <p id="leer"></p>
    </div>

    <div class="erstelleKategorieForm">
        <form id="kategorieForm" name="kategorieForm">
            <input id="bezeichnung" type="text" placeholder="Bezeichnung" name="bezeichnung" required>
            <input id="tag" type="text" placeholder="Tag" name="tag" required>
            <input id="farbe" type="text" placeholder="Color English" name="farbe" required>
            <button type="submit">Hinzufügen</button>
        </form>
    </div>
</div>
</body>
</html>
