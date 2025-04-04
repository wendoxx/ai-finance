#!/bin/bash

echo "Starting Ollama server..."
ollama serve &
ollama pull mistral

echo "Model pulled. Keeping container alive..."
tail -f /dev/null