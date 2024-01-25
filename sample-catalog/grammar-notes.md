# Source definitions grammar

## Concise grammar

```yaml
root: catalog
  user: schema
    username: field text

  blog: catalog
    post: schema
      title: field text minmaxlength(1, 200)
      content: field text
      post-ownership: schema
        created: field datetime
        updated: field datetime
        author: relationship user
      ownership: embedment post-ownership
      comments: relationship comment hasmany

    comment: schema
      author: relationship user
      content: field text
```