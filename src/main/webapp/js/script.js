let test = []; let kategorien = []; let aufgabenPack = [];
window.test = test;
window.kategorien = kategorien;

tinymce.init({
    selector: '#textarea',
    height: 500,
    toolbar: 'undo redo | blocks |' +
        'bold italic backcolor | alignleft aligncenter ' +
        'alignright alignjustify | bullist numlist outdent indent | ' +
        'removeformat | help',
    content_style: 'body { font-family:Helvetica,Arial,sans-serif; font-size:16px }'
});


document.getElementById("toggleKategorieForm").addEventListener("click", function() {
    let form = document.querySelector(".erstelleKategorieForm");

    // Prüfe, ob die Form sichtbar oder unsichtbar ist
    if (form.style.display === "none" || form.style.display === "") {
        form.style.display = "block";  // Zeige die Form
    } else {
        form.style.display = "none";   // Verstecke die Form
    }
});


document.addEventListener("DOMContentLoaded", () => {
    document.getElementById('kategorieForm').addEventListener('submit', e => {
        e.preventDefault();
        const data = new FormData(e.target);
        const bez = data.get('bezeichnung');
        const tag = data.get('tag');
        const farbe = data.get('farbe');

        console.log(bez, tag, farbe);

        document.getElementById('bezeichnung_output').innerHTML += `<p>[${bez}]</p>`;
        document.getElementById('tag_output').innerHTML += `<p>[${tag}]</p>`;
        document.getElementById('farbe_output').innerHTML += `<p><span style="background:${farbe}; opacity: 0.5">[${farbe}]</span></p>`;
        document.getElementById('kategorieForm').reset();
        buttonErstellenKategorie(bez, tag, farbe);
    })
})

function buttonErstellenKategorie(bez, tag, farbe) {
    let btn = document.createElement("BUTTON");
    let textNode = document.createTextNode(bez);
    btn.appendChild(textNode);
    document.getElementById("buttonleiste").appendChild(btn);
    kategorien.push({bez, tag, farbe});

    btn.addEventListener('click', function() {
        const editor = tinymce.get('textarea'); //Instanziieren tinymce

        let text = editor.selection.getContent();
        if(text){
            console.log('Markierter Text: ' + text)
            //tinymce.activeEditor.insertContent(`<mark style="background:${farbe}!important">[${tag}]${text}]</mark>&nbsp`);
            //&nbsp -> verhindert, dass nachfolgender Text mit markiert wird
            tinymce.activeEditor.insertContent(`<span style="background:${farbe}!important; opacity: 0.5">[${tag}]${text}]</span>&nbsp`);
        }else{
            alert('Es kann nicht, nichts markiert werden.');
        }
    });
}

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('aufgabenstellung-form').addEventListener('submit', (e) => {
        e.preventDefault();
        const aufgabentext = document.getElementById('aufgabentext').value;
        document.getElementById('aufgabenstellung').readOnly = true;
        document.getElementById('aufgabentext').readOnly = true;
        tinymce.get('textarea').setContent(aufgabentext);

    })
})

document.getElementById('aufgabeAendern').addEventListener('click', e => {
    let aufgabenstellung = document.getElementById('aufgabenstellung');
    let aufgabentext = document.getElementById('aufgabentext');

    if (aufgabenstellung.readOnly && aufgabentext.readOnly) {
        // Schreibrechte aktivieren
        aufgabenstellung.readOnly = false;
        aufgabentext.readOnly = false;
    } else {
        // Schreibrechte deaktivieren
        aufgabenstellung.readOnly = true;
        aufgabentext.readOnly = true;
        let text = document.getElementById('aufgabentext').value;
        tinymce.get('textarea').setContent(text);
    }

})

document.addEventListener('DOMContentLoaded', () => {

    document.getElementById("getloesung-form").addEventListener('submit', (e) => {
        e.preventDefault();
        const loesung = tinymce.get('textarea').getContent({format : 'text'});

            aufgabenPack.push(loesung);
            console.log(aufgabenPack);
            document.getElementById('aufgabe').innerHTML += `<p>${aufgabenPack.aufgabenstellung}</p>`;
            document.getElementById('aufgabe').innerHTML += `<p>${aufgabenPack.aufgabentext}</p>`;
            document.getElementById('aufgabe').innerHTML += `<p>${loesung}</p>`;
    })
})



