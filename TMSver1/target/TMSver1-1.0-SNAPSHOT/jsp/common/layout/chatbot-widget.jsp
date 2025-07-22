<!-- Chatbot Widget CSS - Self-contained, không ph? thu?c Tailwind -->
<style>
    /* Reset và base styles cho chatbot */
    #chatbot-widget-container * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
    }

    /* Container chính - fixed position, không ?nh h??ng layout */
    #chatbot-widget-container {
        position: fixed !important;
        bottom: 20px !important;
        right: 20px !important;
        z-index: 999999 !important;
        pointer-events: none !important;
        font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, sans-serif !important;
        font-size: 14px !important;
        line-height: 1.5 !important;
    }
    
    /* Chat container */
    #chatbot-container {
        width: 320px !important;
        background: white !important;
        border-radius: 12px !important;
        box-shadow: 0 10px 40px rgba(0, 0, 0, 0.2) !important;
        border: 1px solid #e1e5e9 !important;
        display: flex !important;
        flex-direction: column !important;
        pointer-events: auto !important;
        transition: all 0.3s ease !important;
        overflow: hidden !important;
        max-height: calc(100vh - 40px) !important;
    }
    
    #chatbot-container.expanded {
        height: 400px !important;
    }
    
    #chatbot-container.minimized {
        height: 56px !important;
    }
    
    /* Header */
    #chatbot-header {
        background: #3b82f6 !important;
        color: white !important;
        padding: 12px 16px !important;
        display: flex !important;
        justify-content: space-between !important;
        align-items: center !important;
        flex-shrink: 0 !important;
    }
    
    #chatbot-title {
        font-weight: 600 !important;
        font-size: 14px !important;
    }
    
    #chatbot-toggle {
        background: none !important;
        border: none !important;
        color: white !important;
        cursor: pointer !important;
        padding: 4px !important;
        border-radius: 4px !important;
        transition: background-color 0.2s !important;
        width: 28px !important;
        height: 28px !important;
        display: flex !important;
        align-items: center !important;
        justify-content: center !important;
    }
    
    #chatbot-toggle:hover {
        background: rgba(255, 255, 255, 0.1) !important;
    }
    
    #chatbot-chevron {
        width: 16px !important;
        height: 16px !important;
        transition: transform 0.2s !important;
    }
    
    /* Messages area */
    #chatbot-messages {
        flex: 1 !important;
        padding: 12px !important;
        overflow-y: auto !important;
        background: #f8f9fa !important;
        min-height: 200px !important;
    }
    
    /* Message styling */
    .chatbot-message {
        max-width: 80% !important;
        margin: 8px 0 !important;
        padding: 8px 12px !important;
        border-radius: 12px !important;
        word-wrap: break-word !important;
        font-size: 13px !important;
        line-height: 1.4 !important;
        clear: both !important;
    }
    
    .chatbot-bot-message {
        background: #e5e7eb !important;
        color: #374151 !important;
        float: left !important;
        margin-right: 20% !important;
    }
    
    .chatbot-user-message {
        background: #3b82f6 !important;
        color: white !important;
        float: right !important;
        margin-left: 20% !important;
    }
    
    .chatbot-typing {
        background: #f3f4f6 !important;
        color: #6b7280 !important;
        font-style: italic !important;
        display: none !important;
        float: left !important;
        margin-right: 20% !important;
    }
    
    /* Input area */
    #chatbot-input-area {
        padding: 12px !important;
        border-top: 1px solid #e1e5e9 !important;
        background: white !important;
        flex-shrink: 0 !important;
    }
    
    #chatbot-form {
        display: flex !important;
        gap: 8px !important;
        align-items: flex-end !important;
    }
    
    #chatbot-input {
        flex: 1 !important;
        padding: 8px 12px !important;
        border: 1px solid #d1d5db !important;
        border-radius: 20px !important;
        font-size: 13px !important;
        outline: none !important;
        background: white !important;
        font-family: inherit !important;
        resize: none !important;
        min-height: 36px !important;
        max-height: 100px !important;
    }
    
    #chatbot-input:focus {
        border-color: #3b82f6 !important;
        box-shadow: 0 0 0 2px rgba(59, 130, 246, 0.1) !important;
    }
    
    #chatbot-send-btn {
        background: #3b82f6 !important;
        color: white !important;
        border: none !important;
        border-radius: 20px !important;
        padding: 8px 16px !important;
        font-size: 13px !important;
        font-weight: 500 !important;
        cursor: pointer !important;
        transition: background-color 0.2s !important;
        min-width: 60px !important;
        height: 36px !important;
    }
    
    #chatbot-send-btn:hover:not(:disabled) {
        background: #2563eb !important;
    }
    
    #chatbot-send-btn:disabled {
        background: #9ca3af !important;
        cursor: not-allowed !important;
    }
    
    /* Scrollbar styling */
    #chatbot-messages::-webkit-scrollbar {
        width: 4px !important;
    }
    
    #chatbot-messages::-webkit-scrollbar-track {
        background: transparent !important;
    }
    
    #chatbot-messages::-webkit-scrollbar-thumb {
        background: #d1d5db !important;
        border-radius: 2px !important;
    }
    
    /* Responsive */
    @media (max-width: 480px) {
        #chatbot-widget-container {
            bottom: 10px !important;
            right: 10px !important;
            left: 10px !important;
        }
        
        #chatbot-container {
            width: auto !important;
            max-width: 350px !important;
        }
    }
    
    /* Clearfix cho float messages */
    #chatbot-messages::after {
        content: "" !important;
        display: table !important;
        clear: both !important;
    }
</style>

<!-- Chatbot Widget HTML -->
<div id="chatbot-widget-container">
    <div id="chatbot-container" class="expanded">
        <!-- Header -->
        <div id="chatbot-header">
            <div id="chatbot-title">AI Chatbot</div>
            <button id="chatbot-toggle">
                <svg id="chatbot-chevron" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 9l-7 7-7-7"></path>
                </svg>
            </button>
        </div>
        
        <!-- Messages -->
        <div id="chatbot-messages">
            <div class="chatbot-bot-message chatbot-message">
                Hello, can I help you!
            </div>
            <div id="chatbot-typing" class="chatbot-typing chatbot-message">
                Loading...
            </div>
        </div>
        
        <!-- Input -->
        <div id="chatbot-input-area">
            <form id="chatbot-form">
                <input id="chatbot-input" 
                       type="text" 
                       placeholder="Enter message..." 
                       maxlength="500"
                       autocomplete="off">
                <button type="submit" id="chatbot-send-btn">Post</button>
            </form>
        </div>
    </div>
</div>

<!-- Chatbot JavaScript -->
<script>
(function() {
    'use strict';
    
    const container = document.getElementById('chatbot-container');
    const toggle = document.getElementById('chatbot-toggle');
    const chevron = document.getElementById('chatbot-chevron');
    const form = document.getElementById('chatbot-form');
    const input = document.getElementById('chatbot-input');
    const messages = document.getElementById('chatbot-messages');
    const sendBtn = document.getElementById('chatbot-send-btn');
    const typing = document.getElementById('chatbot-typing');

    if (!container || !toggle || !form) {
        console.warn('Chatbot: Elements not found');
        return;
    }

    let isOpen = true;
    let isProcessing = false;

    // Toggle chat
    toggle.addEventListener('click', function(e) {
        e.preventDefault();
        isOpen = !isOpen;
        
        if (isOpen) {
            container.classList.remove('minimized');
            container.classList.add('expanded');
            chevron.style.transform = 'rotate(0deg)';
        } else {
            container.classList.remove('expanded');
            container.classList.add('minimized');
            chevron.style.transform = 'rotate(180deg)';
        }
    });

    // Show typing
    function showTyping(show) {
        if (typing) {
            typing.style.display = show ? 'block' : 'none';
            scrollToBottom();
        }
    }

    // Scroll to bottom
    function scrollToBottom() {
        if (messages) {
            messages.scrollTop = messages.scrollHeight;
        }
    }

    // Add message
    function addMessage(text, isUser) {
        if (!messages) return;
        
        const div = document.createElement('div');
        div.className = 'chatbot-' + (isUser ? 'user' : 'bot') + '-message chatbot-message';
        div.textContent = text || 'Not have content';
        
        messages.insertBefore(div, typing);
        scrollToBottom();
        
        return div;
    }

    // Handle submit
    function handleSubmit() {
        if (isProcessing) return;
        
        const text = input.value.trim();
        if (!text) return;

        isProcessing = true;
        sendBtn.disabled = true;
        input.disabled = true;
        input.value = '';

        addMessage(text, true);
        showTyping(true);

        // API call
        fetch('http://127.0.0.1:1234/v1/chat/completions', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                model: "phogpt-4b-chat",
                messages: [
                    { role: "system", content: "B?n là tr? lý AI thân thi?n. Tr? l?i ng?n g?n b?ng ti?ng Vi?t." },
                    { role: "user", content: text }
                ],
                max_tokens: 200,
                temperature: 0.7
            })
        })
        .then(response => {
            if (!response.ok) throw new Error('Network error');
            return response.json();
        })
        .then(data => {
            const reply = data.choices?.[0]?.message?.content || 'Sorry! I can answers.';
            showTyping(false);
            addMessage(reply, false);
        })
        .catch(error => {
            showTyping(false);
            console.error('API Error:', error);
            addMessage('Sorry, have a problem. Please try again.', false);
        })
        .finally(() => {
            isProcessing = false;
            sendBtn.disabled = false;
            input.disabled = false;
            input.focus();
        });
    }

    // Events
    if (form) {
        form.addEventListener('submit', function(e) {
            e.preventDefault();
            handleSubmit();
        });
    }

    if (input) {
        input.addEventListener('keydown', function(e) {
            if (e.key === 'Enter' && !e.shiftKey) {
                e.preventDefault();
                handleSubmit();
            }
        });
    }

    // Initial focus
    setTimeout(() => {
        if (input) input.focus();
    }, 100);

})();
</script>