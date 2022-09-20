function checkname(inputtxt) {
  var letters = /^[A-Za-z\s]+$/;
  if (inputtxt !== null) {
    if (!inputtxt.value.match(letters)) {
      inputtxt.focus();
      inputtxt.style.backgroundColor = "red";
      document.getElementById("name").innerHTML = "Invalid name";
      return false;
    } else {
      inputtxt.style.backgroundColor = "";
      document.getElementById("name").innerHTML = "";
      return true;
    }
  }
}
var e;
function checkpass(inputtxt) {
  e = inputtxt;
  var letter = /^((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\W]).{8,64})$/;
  if (inputtxt !== null) {
    if (!inputtxt.value.match(letter)) {
      inputtxt.focus();
      inputtxt.style.backgroundColor = "red";
      document.getElementById("code").innerHTML =
        "Password should contain 1 uppercase, 1 lowercase, 1 special character, 1 number of length minimum 8 characters";
      return false;
    } else {
      inputtxt.style.backgroundColor = "";
      document.getElementById("code").innerHTML = "";
      return true;
    }
  }
}

function checkemail(inputtxt) {
  let letter2 = /^[\w\.-]+@[\w\.-]+\.\w{2,4}$/;
  if (inputtxt !== null) {
    if (!inputtxt.value.match(letter2)) {
      inputtxt.focus();
      inputtxt.style.backgroundColor = "red";
      document.getElementById("email").innerHTML = "Invalid email";
      return false;
    } else {
      inputtxt.style.backgroundColor = "";
      document.getElementById("email").innerHTML = "";
      return true;
    }
  }
}

function matchpass(pass2) {
  var str1 = e.value;
  var str2 = pass2.value;
  if (!(str1 == str2)) {
    pass2.style.backgroundColor = "red";
    e.style.backgroundColor = "red";
    document.getElementById("match").innerHTML = "Password doesn't match";
    return false;
  } else {
    pass2.style.backgroundColor = "";
    e.style.backgroundColor = "";
    document.getElementById("match").innerHTML = "";
    return true;
  }
}

function checkempid(inputtxt) {
  var letter = /^[\d].{2,2}$/;
  if (!inputtxt.value.match(letter)) {
    inputtxt.focus();
    inputtxt.style.backgroundColor = "red";
    document.getElementById("empid").innerHTML = "Invalid id";
    return false;
  } else {
    inputtxt.style.backgroundColor = "";
    document.getElementById("empid").innerHTML = "";
    return true;
  }
}

function checkmark(inputtxt){
  e=inputtxt.id
  if (inputtxt.value>100){
    inputtxt.focus();
    inputtxt.style.backgroundColor= "red";
    document.getElementById("mark"+e).innerHTML="Invalid mark";
    return false;
  }
  else{
    inputtxt.style.backgroundColor="";
    document.getElementById("mark"+e).innerHTML="";
    return true;
  }
}

function checknumber(inputtxt) {
  var letter = /^[\d].{2,2}$/;
  if (!inputtxt.value.match(letter)) {
    inputtxt.focus();
    inputtxt.style.backgroundColor = "red";
    document.getElementById("rno").innerHTML = "Invalid register no. format";
    return false;
  } else {
    inputtxt.style.backgroundColor = "";
    document.getElementById("rno").innerHTML = "";
    return true;
  }
}

function checkdob(inputtxt) {
  var letter = /^([3][0,1]|[0-2]\d)-([1][0-2]|[0]\d)-(\d\d\d\d)$/;
  if (!inputtxt.value.match(letter)) {
    inputtxt.focus();
    inputtxt.style.backgroundColor = "red";
    document.getElementById("birth").innerHTML = "Invalid DOB format";
    return false;
  } else {
    inputtxt.style.backgroundColor = "";
    document.getElementById("birth").innerHTML = "";
    return true;
  }
}
