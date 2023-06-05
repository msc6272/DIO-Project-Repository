const isPortTaken = (port) => new Promise<boolean>((resolve, reject) => {
    const tester = Net.createServer()
         .once('error', err => (err.code == 'EADDRINUSE' ? resolve(false) : reject(err)))
         .once('listening', () => tester.once('close', () => resolve(true)).close())
         .listen(port)
})

console.log(isPortTaken(8828))