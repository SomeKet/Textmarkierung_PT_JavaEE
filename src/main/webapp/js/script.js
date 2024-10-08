tinymce.init({
    selector: '#textarea',
    height: 500,
    toolbar: 'undo redo | blocks | ' +
        'bold italic backcolor | alignleft aligncenter ' +
        'alignright alignjustify | bullist numlist outdent indent | ' +
        'removeformat | help',
    content_style: 'body { font-family:Helvetica,Arial,sans-serif; font-size:16px }'
});

    function toggleKategorieForm() {
        let eingabeBox = document.querySelector(".erstelleKategorieForm");
        eingabeBox.style.display = eingabeBox.style.display === "block" ? "none" : "block";
    }

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
        document.getElementById('farbe_output').innerHTML += `<p><span style="background:${farbe}">[${farbe}]</span></p>`;
        document.getElementById('kategorieForm').reset();
        buttonErstellenKategorie(bez, tag, farbe);
    })
})

function buttonErstellenKategorie(bez, tag, farbe) {
    let btn = document.createElement("BUTTON");
    let textNode = document.createTextNode(bez);
    btn.appendChild(textNode);
    document.getElementById("buttonleiste").appendChild(btn);

    btn.addEventListener('click', function() {
        const editor = tinymce.get('textarea'); //Instanziieren tinymce

        let text = editor.selection.getContent();
        if(text){
            console.log('Markierter Text: ' + text)
            //tinymce.activeEditor.insertContent(`<mark style="background:${farbe}!important">[${tag}]${text}]</mark>&nbsp`);
            //&nbsp -> verhindert, dass nachfolgender Text mit markiert wird
            tinymce.activeEditor.insertContent(`<span style="background:${farbe}!important">[${tag}]${text}]</span>&nbsp`);
        }else{
            alert('Es kann nicht, nichts markiert werden.');
        }
    });
}

