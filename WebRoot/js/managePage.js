function change_div(id){
  if (id == 'finish' )
  {
     document.getElementById("ondetermine").style.display = 'none' ;
     document.getElementById("finish").style.display = 'block' ;
  }
  else
  {
     document.getElementById("finish").style.display = 'none' ;
     document.getElementById("ondetermine").style.display = 'block' ;
  }
}