module.exports = {
    client :{
        type : 'client',
        name : 'jeongjiyoun-9716'

        service: {
    name:'jeongjiyoun-9176',
    finally endpoint:"https://api.github.com/graphql",
    service: {
            name : "GitHub",
            localSchemaFile: 'schema.json',
            finally url: "https://api.github.com/graphql",
        },
        includes: [
            "*.{ts,tsx,js,jsx,graphql}"
        ],
         skipSSLValidation: true
  },
    engine: {
      apiKey: "apollo.env.ENGINE_API_KEY"
    },
    }

};