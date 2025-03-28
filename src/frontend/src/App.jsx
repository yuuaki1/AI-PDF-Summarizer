import { useState } from 'react'
import './App.css'
import axios from 'axios'

function App() {
  const [message, setMessage] = useState("hello")
  const [file, setFile] = useState(null)
  const [response, setResponse] = useState("")

  const sendMessage = async (e) => {
    e.preventDefault()
    if (!message.trim() && !file) {
      console.log("Send a message or a file?");
      return;
    }

    const formData = new FormData()
    formData.append('message', message)
    if (file) formData.append('file', file)

    try {
      const res = await axios.post(`http://localhost:8080/api/chat`, formData, 
      {
        headers: { "Content-Type": "multipart/form-data" },
      })

      setResponse(res.data)
    } catch (error) {
      console.log(error.response?.data || error.message)
    }
  }

  const handleFileChange = (e) => {
    setFile(e.target.files[0])
  }

  return (
    <>
    <h1 className=' items-center text-4xl p-5'>AI PDF Summarizer</h1>
    <p className='p-5'><strong>AI Response: </strong> {response}</p>
      <form onSubmit={sendMessage} className='flex items-center w-full gap-2'>
        <div className='flex flex-col'>
        <label className="bg-black text-white px-3 py-1 m-2 rounded-md cursor-pointer border border-gray-500">
          Upload PDF
          <input type="file" accept=".pdf" className="hidden" onChange={handleFileChange} />
        </label>
        {file && <p>Selected File: {file.name}</p>}
        </div>
        <textarea
          className="m-2 flex-grow min-w-[400px] bg-black w-full px-3 pl-2 py-1 text-white rounded-md resize-none overflow-hidden"
          value={message}
          onChange={(e) => setMessage(e.target.value)}
          rows={1} // Initial height
          onInput={(e) => {
            e.target.style.height = "auto"; // Reset height
            e.target.style.height = e.target.scrollHeight + "px"; // Adjust height
          }}
        />
        <button type='submit' className='bg-black rounded-lg'>Send</button>
      </form>
    </>
  )
}

export default App
