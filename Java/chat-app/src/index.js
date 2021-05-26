const path = require('path')
const http = require('http')
const express = require('express')
const socketio = require('socket.io')
const Filter = require('bad-words')
const { generateMessage, generateLocationMessage } = require('./utils/messages')
const { addUser, removeUser, getUser, getUsersInRoom } = require('./utils/users')

const app = express()
const server = http.createServer(app)
const io = socketio(server)

const port = process.env.PORT || 3000
const publicDirectoryPath = path.join(__dirname, '../public')

app.use(express.static(publicDirectoryPath))

let count = 0

io.on('connection', (socket) => {
    console.log('New WebSocket connection')

    socket.on('join', ( options, callback) => { 
        const { error, user } = addUser({ id: socket.id, ...options })
        
        if (error) {
            return callback(error)
        }

        socket.join(user.room)

        socket.emit('mesazhi', generateMessage('Admin', "Welcome!"))
        // socket.emit('countUpdated', count) // emiting the event from server to the client
        socket.broadcast.to(user.room).emit('mesazhi', generateMessage('Admin', `${user.username} has joined!`)) // its going to send to everybody except this socket
        io.to(user.room).emit('roomData', {
            room: user.room,
            users: getUsersInRoom(user.room)
        })

        callback()
    })

    socket.on('mesazhiKlientit', (message, callback) => {
        const filter = new Filter()
        const user = getUser(socket.id)
        //socket.emit('countUpdated', count) --> emits the event to the specific connection
        if (filter.isProfane(message)) {
            return callback('Profanity is not allowed!')
        }
        if (user) {
            io.to(user.room).emit('mesazhi', generateMessage(user.username, message))  // emits the event to every single connections
            callback() //ky funksion e lajmeron klientin per dergimin e mesazhit
        }
    })

    socket.on('disconnect', () => {
        const user = removeUser(socket.id)
        
        if (user) {
            io.to(user.room).emit('mesazhi', generateMessage('admin', `${user.username} has left!`))
            io.to(user.room).emit('roomData', {
                room: user.room,
                users: getUsersInRoom(user.room)
            })        
        }        
    })

    socket.on('sendLocation', (objekt, callback) => {
        const user = getUser(socket.id)
        io.to(user.room).emit('locationMessage', generateLocationMessage(user.username, `https://google.com/maps?q=${objekt.latitude},${objekt.longitude}`))
        callback()
    })
})

server.listen(port, () => {
    console.log(`Server is up on port ${port}`)
})

// io.to.emit --> it emits an event to everybody in a room
// socket.broadcast.to.emit --> emits an event to everybody except the sender in a room