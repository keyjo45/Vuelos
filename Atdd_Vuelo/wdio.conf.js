exports.config = {
    specs: [
	'./tests/*.js'
    ],
    capabilities: [{
        maxInstances: 5,
        browserName: 'chrome'
    }],
    sync: true,
    logLevel: 'silent',
    coloredLogs: true,
    bail: 0,
    baseUrl: 'http://localhost',
    framework: 'mocha',
}