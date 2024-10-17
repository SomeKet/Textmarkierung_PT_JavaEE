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
    <script type="module" src="js/script.js" defer></script>
    <script type="text/javascript" src="https://cdn.tiny.cloud/1/e0q0w4t1ep5f35kyxt999mzlm4ro2px179u580taztflq9sf/tinymce/7/tinymce.min.js" referrerpolicy="origin"></script>
    <link rel="stylesheet" href="css/style.css">
    <title>Aufagbe</title>
</head>
<body>
<div>
    <form id="aufgabenstellung-form">
        <textarea id="aufgabenstellung" type="text" placeholder="Aufgabenstellung" name="aufgabenstellung" required></textarea>
        <textarea id="aufgabentext" type="text" placeholder="Aufgabentext" name="aufgabentext" required></textarea>
        <input type="submit" value="Aufgabe speichern">
    </form>
    <button id="aufgabeAendern">Aufgabe ändern</button>
    <form id="getloesung-form" >
        <textarea id="textarea" placeholder="Hier kommt die Lösung rein"></textarea>
        <input type="submit" value="Lösung speichern">
    </form>
</div>
<div id="container">
    <div class="buttonleiste1" id="buttonleiste"></div>
    <div class="attribute-kategorie">
        <label for="bezeichnung">Bezeichnung</label>
        <label for="tag">Tag</label>
        <label for="farbe">Farbe</label>
    </div>

    <div class="output-values">
        <p id="bezeichnung_output"></p>
        <p id="tag_output"></p>
        <p id="farbe_output"></p>
    </div>

    <div class="erstelleKategorieForm" style="display:none">
        <form id="kategorieForm" name="kategorieForm">
            <input id="bezeichnung" type="text" placeholder="Bezeichnung" name="bezeichnung" required>
            <input id="tag" type="text" placeholder="Tag" name="tag" required>
            <input id="farbe" type="text" placeholder="Color English" name="farbe" required>
            <button type="submit">Hinzufügen</button>
        </form>
    </div>
    <button id="toggleKategorieForm">Kategorie erstellen</button>
    <div id="aufgabe"></div>
</div>
</body>
</html>
