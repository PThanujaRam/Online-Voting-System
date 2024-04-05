/**
 * 
 */// Function to add a new candidate
function addCandidate() {
    const candidateName = document.getElementById("candidateName").value;
    const candidatePosition = document.getElementById("candidatePosition").value;
    const candidateParty = document.getElementById("candidateParty").value;
    const candidateManifestos = document.getElementById("candidateManifestos").value;
    const imageInput = document.getElementById("candidImage");
    const candidImage = imageInput.files[0];

    const formData = new FormData();
    formData.append("candidateName", candidateName);
    formData.append("candidatePosition", candidatePosition);
    formData.append("candidateParty", candidateParty);
    formData.append("candidateManifestos", candidateManifestos);
    formData.append("candidImage", candidImage);

    fetch('/candidates', {
        method: 'POST',
        body: formData
    })
    .then(response => response.json())
    .then(data => {
        console.log('Candidate added:', data);
        // You can display a success message or update the candidate list here
        // Call a function to update the candidate list
         alert("Candidate added successfully!");
         showNotification('Candidate added successfully!', 'green');
        getCandidatesList();
    })
    .catch(error => {
        console.error('Error adding candidate:', error);
        showNotification('Error adding candidate. Please try again.', 'red');
  
    });
}
// Function to display a notification
function showNotification(message, color) {
    const notification = document.getElementById('notification');
    notification.textContent = message;
    notification.style.backgroundColor = color;
    notification.style.display = 'block';

    // Hide the notification after 3 seconds
    setTimeout(() => {
        notification.style.display = 'none';
    }, 3000);
}
// Function to retrieve and display candidates
function getCandidatesList() {
    fetch('/candidates', {
        method: 'GET',
        headers: {
            'Accept': 'application/json'
        }
    })
    .then(response => response.json())
    .then(data => {
        const candidatesList = document.getElementById('candidatesList');
        candidatesList.innerHTML = ''; // Clear existing list

        data.forEach(candidate => {
            const listItem = document.createElement('li');
            listItem.textContent = `Name: ${candidate.candidateName}, Position: ${candidate.candidatePosition}, Party: ${candidate.candidateParty}, Manifestos: ${candidate.candidateManifestos}`;
            candidatesList.appendChild(listItem);
        });
    })
    .catch(error => {
        console.error('Error retrieving candidates:', error);
    });
}

// Initial call to retrieve and display candidates
getCandidatesList();
