let text = ``;
files.forEach(file => {
    text += `<img src="/files/display?reviewImageName=${file.reviewImagePath}/${file.reviewImageUuid}_${file.reviewImageName}" class="file-list">`;
});
$("#thumbnail-list").append(text);
