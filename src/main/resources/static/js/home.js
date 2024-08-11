const search=()=>{
    // console.log(query)
    const searchElement = document.getElementById("search-input");
    let query = searchElement.value;
    const searchResults = document.getElementById("search-result");
    if(query === ""){
        searchResults.classList.remove("show");
    }else {
        let url = `http://localhost:8080/SearchSt/${query}`;

        fetch(url)
            .then((response)=>{
                return response.json();
            })
            .then((data)=>{
                if (data.length > 0) {
                    let text = `<div class="list-group">`;
                    data.forEach((stations)=>{

                        text += `<a href="#" onclick="select(this)" class="list-group-item list-group-action">${stations.stationName}(${stations.stationCode})</a>`;
                    })
                    text += `</div>`;
                    searchResults.innerHTML = text;
                    searchResults.classList.add("show");
                }else{
                    searchResults.innerHTML = "";
                    searchResults.classList.remove("show");
                }

            })


    }
}
const select = (e)=>{
    const searchElement = document.getElementById("search-input");
    searchElement.value = e.textContent;
    const searchResults = document.getElementById("search-result");
    searchResults.classList.remove("show");
}


const search2=()=>{
    // console.log(query)
    const searchElement = document.getElementById("search-input2");
    let query = searchElement.value;
    const searchResults = document.getElementById("search-result2");
    if(query === ""){
        searchResults.classList.remove("show");
    }else {
        let url = `http://localhost:8080/SearchSt/${query}`;

        fetch(url)
            .then((response)=>{
                return response.json();
            })
            .then((data)=>{
                if (data.length > 0) {
                    let text = `<div class="list-group">`;
                    data.forEach((stations)=>{

                        text += `<a href="#" onclick="select2(this)" class="list-group-item list-group-action">${stations.stationName}(${stations.stationCode})</a>`;
                    })
                    text += `</div>`;
                    searchResults.innerHTML = text;
                    searchResults.classList.add("show");
                }else{
                    searchResults.innerHTML = "";
                    searchResults.classList.remove("show");
                }

            })


    }
}
const select2 = (e)=>{
    const searchElement = document.getElementById("search-input2");
    searchElement.value = e.textContent;
    const searchResults = document.getElementById("search-result2");
    searchResults.classList.remove("show");
}