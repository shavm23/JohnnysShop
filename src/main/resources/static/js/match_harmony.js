
var Agediv;
var testdiv;
var Bodytypediv;
var Input_Bodytype = "None";
var Rowcount = 0;
var Global_Array = [];
 
 
 
 
 function absoluteval(num1,num2)
{
	 
	return Math.abs(num1 - num2);
}

function findmatches()
{
		var matches;
		var i;
		var j;
		for(i=0;i<Rowcount;i++)
		{
			matches = 0;
			document.getElementById("showmatches").value+= Global_Array[i][0] + " " + Global_Array[i][1] + "'s Matches\n";
			for(j=0;j<Rowcount;j++)
			{
				if( (absoluteval(Global_Array[i][3],Global_Array[j][3]))<=10 && (absoluteval(Global_Array[i][6],Global_Array[j][6]))<=10)
				{
					if(Global_Array[i][4] != Global_Array[j][4])
					{
						document.getElementById("showmatches").value += Global_Array[j][0] + " " + Global_Array[j][1] +"\n";
						matches++;
					}
				}
			}
			if(matches==0)
			{
				document.getElementById("showmatches").value += "Sorry 0 Matches at the moment, Try again Later\n\n";
			}
			else
			{
				document.getElementById("showmatches").value += "Woah you got " + matches + "Matches\n\n";
			}
		}			
		
		
		
}
function pickbody(body)
{
	Input_Bodytype = body	
}

function showall()
{
	var row;
	var col;
	document.getElementById("Showallpersons").value = "First Name \tLast Name\t\tDOB\t\t\tAge\t\tGender\t\tBody Type\t\tHeight\n\n"
	for(row = 0 ; row <Rowcount;row++)
	{
		for(col=0;col<7;col++)
		{	
			document.getElementById("Showallpersons").value += Global_Array[row][col] +"\t,\t";
		}
		document.getElementById("Showallpersons").value +="\n";
	}
}
function addnew()
{
	
	var x = "Yes";
	var Input_FirstName = document.mainform.First_Name.value;
	var Input_LastName = document.mainform.Last_Name.value;
	var Input_DOB = document.mainform.DOB.value;
	var Input_Age = document.mainform.age.value;
	
	var Input_Gender;
	if(document.getElementById("Male").checked)
		Input_Gender = "Male";
	if(document.getElementById("Female").checked)
		Input_Gender = "Female";
	var Input_Height = document.mainform.height.value;
	
	if(Input_FirstName.length<3)
	{
		window.alert("First Name is less than 3 characters");
		x = "No";
	}
	if(Input_LastName.length<3)
	{
		window.alert("Last Name is less than 3 characters");
		x = "No";
	}
	if(Input_Age <18 || Input_Age>70)
	{
		window.alert("Invalid Input \n Age must be between the 18 - 70 ");
		x = "No";
	}
	if(Input_Gender!="Male"&& Input_Gender!="Female")
	{
		window.alert("Please select Gender type");
		x = "No";
	}
	if(Input_Bodytype == "None")
	{
		window.alert("Pleae select Body Type");
		x = "No";
	}
	if(Input_Height<170||Input_Height>200)
	{
		window.alert("Height must be between 170-200 cm");
		x = "No";
	}
	if(x=="Yes")
	{
		window.alert("Welcome to Match Harmony :) \nUser successfuly added to the System.");
		Global_Array.push([Input_FirstName,Input_LastName,Input_DOB,Input_Age,Input_Gender,Input_Bodytype,Input_Height]);
		Rowcount++;
		showall();	
	}
	
	
	
	
}


function CalAge()
{	
	var minAge = 18;
	var maxAge = 70;
	var age;
	var Dateofbirth = new Date(document.getElementById("DOB").value);
	var age = (new Date().getTime() - Dateofbirth.getTime())/(31536000000) ;
	
	document.getElementById("age").value = Math.floor(age);
}




function bodyselect(gender)
{
	Bodytypediv = document.getElementById("Bodytype");
	
	if(gender == "Male")
	{
		Bodytypediv.innerHTML = "Oval <input type = \"radio\" name = \"body\" id = \"Maletype1\" value = \"Oval\" onclick = \"pickbody('oval');\" >" +

		"Triangle <input type = \"radio\" name = \"body\" id = \"Maletype2\" value = \"Triangle\" onclick = \"pickbody('Triangle');\">" + "Rectangle <input type = \"radio\" name = \"body\" id = \"Maletype3\" value = \"Rectangle\" onclick = \"pickbody('Rectangle');\" >" +"Rhomboid <input type = \"radio\" name = \"body\" id = \"Maletype4\" value = \"Rhomboid\" onclick = \"pickbody('Rhomboid');\">" + "Inverted Triangle <input type = \"radio\" name = \"body\" id = \"Maletype5\" value = \"Inverted Triangle\" onclick = \"pickbody('Inverted Triangle');\">";
	}
	else
	if(gender == "Female")
	{
		Bodytypediv.innerHTML = "<td> Apple <input type = \"radio\" name = \"body\" id = \"Femaletype1\" value = \"Apple\" onclick = \"pickbody('Apple');\">" +
		"&nbsp Pear <input type = \"radio\" name = \"body\" id = \"Femaletype2\" value = \"Pear\" onclick = \"pickbody('Pear');\" >"+ "&nbsp Pencil <input type = \"radio\" name = \"body\" id = \"Femaletype3\" value = \"Pencil\" onclick = \"pickbody('Pencil');\">" + "&nbsp Hourglass <input type = \"radio\" name = \"body\" id = \"Femaletype4\" value = \"Hourglass\" onclick = \"pickbody('Hourglass');\">" + "&nbsp Round <input type = \"radio\" name = \"body\" id = \"Femaletype5\" value = \"Round\" onclick = \"pickbody('Round');\">" ;
	}
}	

function mybody()
{
	
}










function validatefname() {
  fnm =mainform.fname.value;
  
  if (fnm=='') 
  {
  window.alert('Your First name is a required field. Please try again.');
  event.returnValue=false;
}

}


function validatelname() {

lmn = mainform.lname.value;

if (lmn== '') {
window.alert('Your Last name is a required field. Please try again.');
  event.returnValue=false;
 }
 
 }

function validateage() {
if (mainform.age.options[0].selected) {
alert('Please choose an Age Range.');
event.returnValue=false;
}
}

function validatecountry1() 
{
if (mainform.country1.options[0].selected) 
{
alert('Select your country');
event.returnValue=false;
}
}

function validatedob() 
{
 dob =mainform.dob.value;
  
  if (dob=='') {
  window.alert('Please enter your Date of Birth.');
  event.returnValue=false;
 }
}


var slideIndex = 0;
showSlides();
var slides,dots;

function showSlides() {
    var i;
    slides = document.getElementsByClassName("mySlides");
    dots = document.getElementsByClassName("dot");
    for (i = 0; i < slides.length; i++) {
       slides[i].style.display = "none";  
    }
    slideIndex++;
    if (slideIndex> slides.length) {slideIndex = 1}    
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";  
    dots[slideIndex-1].className += " active";
    setTimeout(showSlides, 2000); // Change image every 2 seconds
}

function plusSlides(position) {
    slideIndex +=position;
    if (slideIndex> slides.length) {slideIndex = 1}
    else if(slideIndex<1){slideIndex = slides.length}
    for (i = 0; i < slides.length; i++) {
       slides[i].style.display = "none";  
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
        slides[slideIndex-1].style.display = "block";  
        dots[slideIndex-1].className += " active";
    }
}

function currentSlide(index) {
    if (index> slides.length) {index = 1}
    else if(index<1){index = slides.length}
    for (i = 0; i < slides.length; i++) {
       slides[i].style.display = "none";  
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
        slides[index-1].style.display = "block";  
        dots[index-1].className += " active";
    }
}

var vid = document.getElementById("bgvid");
var pauseButton = document.querySelector("#polina button");

if (window.matchMedia('(prefers-reduced-motion)').matches) {
    vid.removeAttribute("autoplay");
    vid.pause();
    pauseButton.innerHTML = "Paused";
}

function vidFade() {
  vid.classList.add("stopfade");
}

vid.addEventListener('ended', function()
{
// only functional if "loop" is removed 
vid.pause();
// to capture IE10
vidFade();
}); 


pauseButton.addEventListener("click", function() {
  vid.classList.toggle("stopfade");
  if (vid.paused) {
    vid.play();
    pauseButton.innerHTML = "Pause";
  } else {
    vid.pause();
    pauseButton.innerHTML = "Paused";
  }
})





