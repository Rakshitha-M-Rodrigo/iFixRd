// Definition of the movie schema
var movieSchema = new Schema({
    name: String,
    director: String,
    release: Number
});

// Bind autoincrement plugin with schema.
movieSchema.plugin(autoIncrement.plugin, 'Movie');

// Prepare object for export.
var Movie = connection.model('Movie', movieSchema);

// Seeding Initial Data. Populates only once, then the code is skipped. 
Movie.find(function(err, movies){
    // If intial data already exists, skip the rest of the method.
    if (movies.length) {
        return;
    }

// Initialisation of movies array.  
var movies = [
    {
        id: 1,
        name: "Forrest Gump",
        director: "Robert Zemeckis",
        release: 1994
    },
    { 
        id: 2,
        name: "Donnie Darko",
        director: "Richard Kelly",
        release: 2001
    },
    {
        id: 3,
        name: "Inception",
        director: "Christopher Nolan",
        release: 2010
    }
];

// A simulation of creating new IDs. Basically get the last element and increase the value of an ID.

function getNewId(){
    return movies[movies.length -1].id + 1;
}

// Function findIndexOfElement helps to identify the array index according to specified key/value pair.

function findIndexOfElement(inputArray, key, value){
    for (var i = 0; i < inputArray.length; i++){
        if (inputArray[i][key] === value){
            return i;
        }
    }
return -1;
}