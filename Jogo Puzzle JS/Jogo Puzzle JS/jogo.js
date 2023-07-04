
const colors = ["red", "blue", "green", "yellow", "orange", "purple", "pink", "black", "white"];


let level = 1;
let timer = 3;
let score = 0;
let targetWord = "";
let targetColor = "";


const levelElement = document.getElementById("level");
const timerElement = document.getElementById("timer");
const scoreElement = document.getElementById("score");
const targetWordElement = document.getElementById("target-word");
const buttonContainer = document.getElementById("button-container");
const startButton = document.getElementById("start-button");


startButton.addEventListener("click", startGame);


function startGame() {
  level = 1;
  timer = 3;
  score = 0;
  updateLevel();
  updateScore();
  startButton.disabled = true;
  startButton.textContent = "Wait...";
  nextRound();
  setTimeout(startTimer, 1000);
}


function updateLevel() {
  levelElement.textContent = level;
}


function updateScore() {
  scoreElement.textContent = score;
}


function startTimer() {
  if (timer > 0) {
    timer--;
    timerElement.textContent = timer;
    setTimeout(startTimer, 1000);
  } else {
    endGame();
  }
}


function endGame() {
  startButton.disabled = false;
  startButton.textContent = "Restart";
  buttonContainer.querySelectorAll(".color-button").forEach(button => {
    button.disabled = true;
  });

  if(endGame){
    alert("Fim do Jogo")
  }
}


function shuffleButtons() {
  const buttons = Array.from(buttonContainer.querySelectorAll(".color-button"));
  for (let i = buttons.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [buttons[i].className, buttons[j].className] = [buttons[j].className, buttons[i].className];
  }
}


function generateTarget() {
  const randomIndex = Math.floor(Math.random() * colors.length);
  targetColor = colors[randomIndex];
  targetWord = colors[Math.floor(Math.random() * colors.length)];
  targetWordElement.textContent = targetWord;
  targetWordElement.style.color = targetColor;
}


function checkAnswer(event) {
  const selectedColor = event.target.className.split(" ")[1];
  if (selectedColor === targetColor) {
    score++;
    updateScore();
    if (score % 10 === 0) {
      level++;
      updateLevel();
    }
    nextRound();
  } else {
    endGame();
  }
}


function nextRound() {
  timer = getTimerByLevel(level);
  timerElement.textContent = timer;
  generateTarget();
  shuffleButtons();
  buttonContainer.querySelectorAll(".color-button").forEach(button => {
    button.disabled = false;
    button.removeEventListener("click", checkAnswer);
    button.addEventListener("click", checkAnswer);
  });
}

function getTimerByLevel(level) {
  switch (level) {
    case 1:
      return 3;
    case 2:
      return 2;
    case 3:
      return 2;
    case 4:
      return 1.7;
    case 5:
      return 1.5;
    case 6:
      return 1;
    default:
      return 1;
  }
}


buttonContainer.querySelectorAll(".color-button").forEach(button => {
  button.addEventListener("click", checkAnswer);
});
