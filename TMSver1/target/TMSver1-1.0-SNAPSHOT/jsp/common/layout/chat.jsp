<!-- Giao di?n Chatbot -->
<script src="https://cdn.tailwindcss.com"></script>

<style>
    #chat-container {
        position: fixed;
        bottom: 20px;
        right: 20px;
        z-index: 9999;
        width: 320px;
        height: 24rem;
        transition: all 0.3s ease-in-out;
    }

    .chat-message {
        max-width: 80%;
        margin: 0.5rem 1rem;
        padding: 0.75rem;
        border-radius: 12px;
        font-size: 14px;
        font-family: 'Poppins', sans-serif;
    }

    .user-message {
        background-color: #3b82f6;
        color: white;
        margin-left: auto;
    }

    .bot-message {
        background-color: #e5e7eb;
        color: #1f2937;
    }
</style>

<div id="chat-container" class="bg-white rounded-lg shadow-xl flex flex-col overflow-hidden">
    <!-- Chat Header -->
    <div class="bg-blue-600 text-white p-4 flex justify-between items-center">
        <h3 class="font-semibold">AI Chatbot</h3>
        <button id="toggle-chat" class="focus:outline-none text-white text-lg font-bold">-</button>
    </div>

    <!-- Chat Messages -->
    <div id="chat-messages" class="flex-1 p-4 overflow-y-auto">
        <div class="bot-message chat-message">
            Xin chào! Tôi là AI Chatbot. Hôm nay tôi có th? giúp gì cho b?n.
        </div>
    </div>

    <!-- Chat Input -->
    <div class="p-4 border-t">
        <form id="chat-form" class="flex gap-2">
            <input id="chat-input" type="text" placeholder="Nh?p tin nh?n..."
                class="flex-1 p-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-600">
            <button type="submit"
                class="bg-blue-600 text-white px-4 py-2 rounded-lg hover:bg-blue-700 transition">Post</button>
        </form>
    </div>
</div>

<script>
    const chatContainer = document.getElementById('chat-container');
    const toggleChat = document.getElementById('toggle-chat');
    const chatForm = document.getElementById('chat-form');
    const chatInput = document.getElementById('chat-input');
    const chatMessages = document.getElementById('chat-messages');

    let isChatOpen = true;

    toggleChat.addEventListener('click', () => {
        isChatOpen = !isChatOpen;
        chatContainer.style.height = isChatOpen ? '24rem' : '3.5rem';
    });

    chatForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        const message = chatInput.value.trim();
        if (!message) return;

        // Hi?n th? tin nh?n ng??i dùng
        const userMessage = document.createElement('div');
        userMessage.className = 'user-message chat-message';
        userMessage.textContent = message;
        chatMessages.appendChild(userMessage);

        chatInput.value = '';
        chatMessages.scrollTop = chatMessages.scrollHeight;

        try {
            const response = await fetch('http://127.0.0.1:1234/v1/chat/completions', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({
                    model: "phogpt-4b-chat",
                    messages: [
                        { role: "system", content: "B?n là tr? lý AI thân thi?n, tr? l?i b?ng ti?ng Vi?t." },
                        { role: "user", content: message }
                    ],
                    max_tokens: 150
                })
            });

            if (!response.ok) {
                throw new Error(`L?i ${response.status}: ${response.statusText}`);
            }

            const data = await response.json();
            const reply = data.choices?.[0]?.message?.content || 'Không có ph?n h?i.';

            const botMessage = document.createElement('div');
            botMessage.className = 'bot-message chat-message';
            botMessage.textContent = reply;
            chatMessages.appendChild(botMessage);
            chatMessages.scrollTop = chatMessages.scrollHeight;

        } catch (error) {
            const botMessage = document.createElement('div');
            botMessage.className = 'bot-message chat-message';
            botMessage.textContent = `L?i: ${error.message}`;
            chatMessages.appendChild(botMessage);
            chatMessages.scrollTop = chatMessages.scrollHeight;
        }
    });
</script>