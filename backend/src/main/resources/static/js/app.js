document.addEventListener("DOMContentLoaded", function() {
    const searchForm = document.getElementById("searchForm");
    const therapistsList = document.getElementById("therapistsList");

    searchForm.addEventListener("submit", function(event) {
        event.preventDefault();
        
        const searchTerm = document.getElementById("professional").value;
        fetch(`/therapists/search?term=${searchTerm}`)
            .then(response => response.json())
            .then(data => {
                displayTherapists(data);
            })
            .catch(error => {
                console.error("Erro ao buscar terapeutas:", error);
            });
    });

    function displayTherapists(therapists) {
        therapistsList.innerHTML = ""; // Limpa a lista de terapeutas antes de adicionar os novos

        therapists.forEach(therapist => {
            const therapistElement = document.createElement("div");
            therapistElement.innerHTML = `
                <div>
                    <div class="foto"></div>
                    <div>
                        <h3>${therapist.name}</h3>
                        <p>Formação: <span>${therapist.formation}</span></p>
                        <p>Cidade: <span>${therapist.city}</span></p>
                    </div>
                    <div>
                        <p>Horários: <span>${therapist.availability}</span></p>
                    </div>
                    <div>
                        <p>Valor: <span>${therapist.price}</span></p>
                    </div>
                    <div>
                        <p>Descrição: <span>${therapist.description}</span></p>
                    </div>
                    <button>Agendar</button>
                </div>
            `;
            therapistsList.appendChild(therapistElement);
        });
    }
});
