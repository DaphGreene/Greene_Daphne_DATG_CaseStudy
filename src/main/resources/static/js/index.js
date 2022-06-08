// Seach bar
function search_shows() {
  let input = document.getElementsById("searchbar").value;
  input = input.toLowerCase();
  let x = document.getElementsByClassName("city");

  for (i = 0; i < x.length; i++) {
    if (!x[i].innerHTML.toLowerCase().includes(input)) {
      x[i].style.display = "none";
    } else {
      x[i].style.display = "list-item";
    }
  }
}

const show = [
  {
    city: "Phoenix",
    venue: "The Rebel Lounge",
    date: "06/17",
    preorder: 15,
    door: 20,
    link: "https://tickets.com",
  },
  {
    city: "Los Angeles",
    venue: "The Troubador",
    date: "07/20",
    preorder: 15,
    door: 20,
    link: "https://tickets.com",
  },
  {
    city: "San Diego",
    venue: "Casbah",
    date: "08/10",
    preorder: 15,
    door: 20,
    link: "https://tickets.com",
  },
  {
    city: "Portland",
    venue: "TBD",
    date: "09/18",
    preorder: 15,
    door: 20,
    link: "https://tickets.com",
  },
];

// Shows-Table generator
const showsTable = document.getElementById("tableBody");
console.log(showsTable);
// Iterating over the shows Set
show.forEach((show) => {
  const newRow = document.createElement("tr");
  const newFormat = document.createElement("td");
  newFormat.innerHTML = ">";
  newRow.appendChild(newFormat);
  const newCity = document.createElement("td");
  newCity.innerHTML = show.city;
  newRow.appendChild(newCity);
  const newVenue = document.createElement("td");
  newVenue.innerHTML = show.venue;
  newRow.appendChild(newVenue);
  const newDate = document.createElement("td");
  newDate.innerHTML = show.date;
  newRow.appendChild(newDate);
  const newTickets = document.createElement("td");
  newTickets.innerHTML = `<a href=${show.link}>$${show.preorder}/$${show.door} DOS</a>`;
  newRow.appendChild(newTickets);
  showsTable.appendChild(newRow);
});
