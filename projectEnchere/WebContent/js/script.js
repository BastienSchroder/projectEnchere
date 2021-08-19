function getRandomIntInclusive(min, max) {
  min = Math.ceil(min);
  max = Math.floor(max);
  return Math.floor(Math.random() * (max - min +1)) + min;
}

document.getElementById("btnBlague").addEventListener("click", function() {
    var random = getRandomIntInclusive(0,104);
    var joke = tabBlague[0][random].joke;
    var answer = tabBlague[0][random].answer;
    document.getElementsByClassName('joke')[0].value=joke;
    document.getElementsByClassName('answer')[0].value=answer;

});


document.getElementById("btnBlagueConnecte").addEventListener("click", function() {
    var random = getRandomIntInclusive(0,tabBlague[0].length);
    var joke = tabBlague[0][random].joke;
    var answer = tabBlague[0][random].answer;
    document.getElementsByClassName('joke')[1].value=joke;
    document.getElementsByClassName('answer')[1].value=answer;
});


