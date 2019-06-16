package com.mynote.kano.kano;

import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.Query;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.internal.UnmodifiableMapBuilder;
import com.apollographql.apollo.api.internal.Utils;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Generated("Apollo GraphQL")
public final class EntryDetailQuery implements Query<EntryDetailQuery.Data, EntryDetailQuery.Data, EntryDetailQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query EntryDetailQuery($repoFullName: String!) {\n"
      + "  entry(repoFullName: $repoFullName) {\n"
      + "    __typename\n"
      + "    id\n"
      + "    repository {\n"
      + "      __typename\n"
      + "      full_name\n"
      + "      description\n"
      + "      owner {\n"
      + "        __typename\n"
      + "        login\n"
      + "      }\n"
      + "    }\n"
      + "    postedBy {\n"
      + "      __typename\n"
      + "      login\n"
      + "    }\n"
      + "    comments {\n"
      + "      __typename\n"
      + "      id\n"
      + "      content\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String OPERATION_ID = "0e9c3aadca08ecffe295b30ba0d9ac9205e21e3de4d1a2ef8be974604d30ffa7";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  public static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "EntryDetailQuery";
    }
  };

  private final EntryDetailQuery.Variables variables;

  public EntryDetailQuery(@NotNull String repoFullName) {
    Utils.checkNotNull(repoFullName, "repoFullName == null");
    variables = new EntryDetailQuery.Variables(repoFullName);
  }

  @Override
  public String operationId() {
    return OPERATION_ID;
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public EntryDetailQuery.Data wrapData(EntryDetailQuery.Data data) {
    return data;
  }

  @Override
  public EntryDetailQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<Data> responseFieldMapper() {
    return new Data.Mapper();
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public OperationName name() {
    return OPERATION_NAME;
  }

  public static final class Builder {
    private @NotNull String repoFullName;

    Builder() {
    }

    public Builder repoFullName(@NotNull String repoFullName) {
      this.repoFullName = repoFullName;
      return this;
    }

    public EntryDetailQuery build() {
      Utils.checkNotNull(repoFullName, "repoFullName == null");
      return new EntryDetailQuery(repoFullName);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @NotNull String repoFullName;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@NotNull String repoFullName) {
      this.repoFullName = repoFullName;
      this.valueMap.put("repoFullName", repoFullName);
    }

    public @NotNull String repoFullName() {
      return repoFullName;
    }

    @Override
    public Map<String, Object> valueMap() {
      return Collections.unmodifiableMap(valueMap);
    }

    @Override
    public InputFieldMarshaller marshaller() {
      return new InputFieldMarshaller() {
        @Override
        public void marshal(InputFieldWriter writer) throws IOException {
          writer.writeString("repoFullName", repoFullName);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("entry", "entry", new UnmodifiableMapBuilder<String, Object>(1)
      .put("repoFullName", new UnmodifiableMapBuilder<String, Object>(2)
        .put("kind", "Variable")
        .put("variableName", "repoFullName")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable Entry entry;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public Data(@Nullable Entry entry) {
      this.entry = entry;
    }

    /**
     * A single entry
     */
    public @Nullable Entry entry() {
      return this.entry;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], entry != null ? entry.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "entry=" + entry
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.entry == null) ? (that.entry == null) : this.entry.equals(that.entry));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (entry == null) ? 0 : entry.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final Entry.Mapper entryFieldMapper = new Entry.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final Entry entry = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<Entry>() {
          @Override
          public Entry read(ResponseReader reader) {
            return entryFieldMapper.map(reader);
          }
        });
        return new Data(entry);
      }
    }
  }

  public static class Entry {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("id", "id", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("repository", "repository", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("postedBy", "postedBy", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("comments", "comments", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @NotNull String __typename;

    final int id;

    final @Nullable Repository repository;

    final @Nullable PostedBy postedBy;

    final @NotNull List<Comment> comments;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public Entry(@NotNull String __typename, int id, @Nullable Repository repository,
        @Nullable PostedBy postedBy, @NotNull List<Comment> comments) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = id;
      this.repository = repository;
      this.postedBy = postedBy;
      this.comments = Utils.checkNotNull(comments, "comments == null");
    }

    public @NotNull String __typename() {
      return this.__typename;
    }

    /**
     * The SQL ID of this entry
     */
    public int id() {
      return this.id;
    }

    /**
     * Information about the repository from GitHub
     */
    public @Nullable Repository repository() {
      return this.repository;
    }

    /**
     * The GitHub user who submitted this entry
     */
    public @Nullable PostedBy postedBy() {
      return this.postedBy;
    }

    /**
     * Comments posted about this repository
     */
    public @NotNull List<Comment> comments() {
      return this.comments;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeInt($responseFields[1], id);
          writer.writeObject($responseFields[2], repository != null ? repository.marshaller() : null);
          writer.writeObject($responseFields[3], postedBy != null ? postedBy.marshaller() : null);
          writer.writeList($responseFields[4], comments, new ResponseWriter.ListWriter() {
            @Override
            public void write(List items, ResponseWriter.ListItemWriter listItemWriter) {
              for (Object item : items) {
                listItemWriter.writeObject(((Comment) item).marshaller());
              }
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Entry{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "repository=" + repository + ", "
          + "postedBy=" + postedBy + ", "
          + "comments=" + comments
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Entry) {
        Entry that = (Entry) o;
        return this.__typename.equals(that.__typename)
         && this.id == that.id
         && ((this.repository == null) ? (that.repository == null) : this.repository.equals(that.repository))
         && ((this.postedBy == null) ? (that.postedBy == null) : this.postedBy.equals(that.postedBy))
         && this.comments.equals(that.comments);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= id;
        h *= 1000003;
        h ^= (repository == null) ? 0 : repository.hashCode();
        h *= 1000003;
        h ^= (postedBy == null) ? 0 : postedBy.hashCode();
        h *= 1000003;
        h ^= comments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Entry> {
      final Repository.Mapper repositoryFieldMapper = new Repository.Mapper();

      final PostedBy.Mapper postedByFieldMapper = new PostedBy.Mapper();

      final Comment.Mapper commentFieldMapper = new Comment.Mapper();

      @Override
      public Entry map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final int id = reader.readInt($responseFields[1]);
        final Repository repository = reader.readObject($responseFields[2], new ResponseReader.ObjectReader<Repository>() {
          @Override
          public Repository read(ResponseReader reader) {
            return repositoryFieldMapper.map(reader);
          }
        });
        final PostedBy postedBy = reader.readObject($responseFields[3], new ResponseReader.ObjectReader<PostedBy>() {
          @Override
          public PostedBy read(ResponseReader reader) {
            return postedByFieldMapper.map(reader);
          }
        });
        final List<Comment> comments = reader.readList($responseFields[4], new ResponseReader.ListReader<Comment>() {
          @Override
          public Comment read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Comment>() {
              @Override
              public Comment read(ResponseReader reader) {
                return commentFieldMapper.map(reader);
              }
            });
          }
        });
        return new Entry(__typename, id, repository, postedBy, comments);
      }
    }
  }

  public static class Repository {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("full_name", "full_name", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("description", "description", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("owner", "owner", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @NotNull String __typename;

    final @NotNull String full_name;

    final @Nullable String description;

    final @Nullable Owner owner;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public Repository(@NotNull String __typename, @NotNull String full_name,
        @Nullable String description, @Nullable Owner owner) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.full_name = Utils.checkNotNull(full_name, "full_name == null");
      this.description = description;
      this.owner = owner;
    }

    public @NotNull String __typename() {
      return this.__typename;
    }

    /**
     * The full name of the repository with the username, e.g. apollostack/GitHunt-API
     */
    public @NotNull String full_name() {
      return this.full_name;
    }

    /**
     * The description of the repository
     */
    public @Nullable String description() {
      return this.description;
    }

    /**
     * The owner of this repository on GitHub, e.g. apollostack
     */
    public @Nullable Owner owner() {
      return this.owner;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], full_name);
          writer.writeString($responseFields[2], description);
          writer.writeObject($responseFields[3], owner != null ? owner.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Repository{"
          + "__typename=" + __typename + ", "
          + "full_name=" + full_name + ", "
          + "description=" + description + ", "
          + "owner=" + owner
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Repository) {
        Repository that = (Repository) o;
        return this.__typename.equals(that.__typename)
         && this.full_name.equals(that.full_name)
         && ((this.description == null) ? (that.description == null) : this.description.equals(that.description))
         && ((this.owner == null) ? (that.owner == null) : this.owner.equals(that.owner));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= full_name.hashCode();
        h *= 1000003;
        h ^= (description == null) ? 0 : description.hashCode();
        h *= 1000003;
        h ^= (owner == null) ? 0 : owner.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Repository> {
      final Owner.Mapper ownerFieldMapper = new Owner.Mapper();

      @Override
      public Repository map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String full_name = reader.readString($responseFields[1]);
        final String description = reader.readString($responseFields[2]);
        final Owner owner = reader.readObject($responseFields[3], new ResponseReader.ObjectReader<Owner>() {
          @Override
          public Owner read(ResponseReader reader) {
            return ownerFieldMapper.map(reader);
          }
        });
        return new Repository(__typename, full_name, description, owner);
      }
    }
  }

  public static class Owner {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("login", "login", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @NotNull String __typename;

    final @NotNull String login;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public Owner(@NotNull String __typename, @NotNull String login) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.login = Utils.checkNotNull(login, "login == null");
    }

    public @NotNull String __typename() {
      return this.__typename;
    }

    /**
     * The name of the user, e.g. apollostack
     */
    public @NotNull String login() {
      return this.login;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], login);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Owner{"
          + "__typename=" + __typename + ", "
          + "login=" + login
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Owner) {
        Owner that = (Owner) o;
        return this.__typename.equals(that.__typename)
         && this.login.equals(that.login);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= login.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Owner> {
      @Override
      public Owner map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String login = reader.readString($responseFields[1]);
        return new Owner(__typename, login);
      }
    }
  }

  public static class PostedBy {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("login", "login", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @NotNull String __typename;

    final @NotNull String login;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public PostedBy(@NotNull String __typename, @NotNull String login) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.login = Utils.checkNotNull(login, "login == null");
    }

    public @NotNull String __typename() {
      return this.__typename;
    }

    /**
     * The name of the user, e.g. apollostack
     */
    public @NotNull String login() {
      return this.login;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], login);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "PostedBy{"
          + "__typename=" + __typename + ", "
          + "login=" + login
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof PostedBy) {
        PostedBy that = (PostedBy) o;
        return this.__typename.equals(that.__typename)
         && this.login.equals(that.login);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= login.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<PostedBy> {
      @Override
      public PostedBy map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String login = reader.readString($responseFields[1]);
        return new PostedBy(__typename, login);
      }
    }
  }

  public static class Comment {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("id", "id", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("content", "content", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @NotNull String __typename;

    final int id;

    final @NotNull String content;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public Comment(@NotNull String __typename, int id, @NotNull String content) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = id;
      this.content = Utils.checkNotNull(content, "content == null");
    }

    public @NotNull String __typename() {
      return this.__typename;
    }

    /**
     * The SQL ID of this entry
     */
    public int id() {
      return this.id;
    }

    /**
     * The text of the comment
     */
    public @NotNull String content() {
      return this.content;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeInt($responseFields[1], id);
          writer.writeString($responseFields[2], content);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Comment{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "content=" + content
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Comment) {
        Comment that = (Comment) o;
        return this.__typename.equals(that.__typename)
         && this.id == that.id
         && this.content.equals(that.content);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= id;
        h *= 1000003;
        h ^= content.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Comment> {
      @Override
      public Comment map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final int id = reader.readInt($responseFields[1]);
        final String content = reader.readString($responseFields[2]);
        return new Comment(__typename, id, content);
      }
    }
  }
}