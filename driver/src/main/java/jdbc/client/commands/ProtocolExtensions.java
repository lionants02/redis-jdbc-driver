package jdbc.client.commands;

import org.jetbrains.annotations.NotNull;
import redis.clients.jedis.args.Rawable;
import redis.clients.jedis.commands.ProtocolCommand;
import redis.clients.jedis.util.SafeEncoder;

public class ProtocolExtensions {

    /* --------------------------------------------- Native --------------------------------------------- */

    public enum CommandEx implements ProtocolCommand {
        ;

        private final byte[] raw;

        CommandEx() {
            raw = SafeEncoder.encode(name());
        }

        @Override
        public byte[] getRaw() {
            return raw;
        }
    }

    enum KeywordEx implements Rawable {
        ;

        private final byte[] raw;

        KeywordEx() {
            raw = SafeEncoder.encode(name());
        }

        @Override
        public byte[] getRaw() {
            return raw;
        }
    }

    /* --------------------------------------------- RedisJSON --------------------------------------------- */

    public enum JsonCommandEx implements ProtocolCommand {
        DEBUG("JSON.DEBUG"),
        FORGET("JSON.FORGET"),
        MERGE("JSON.MERGE"),
        MSET("JSON.MSET"),
        NUMMULTBY("JSON.NUMMULTBY");

        private final byte[] raw;

        JsonCommandEx(@NotNull String alt) {
            raw = SafeEncoder.encode(alt);
        }

        @Override
        public byte[] getRaw() {
            return raw;
        }
    }

    enum JsonKeywordEx implements Rawable {
        MEMORY;

        private final byte[] raw;

        JsonKeywordEx() {
            raw = SafeEncoder.encode(name());
        }

        @Override
        public byte[] getRaw() {
            return raw;
        }
    }

    /* ------------------------------------------------------------------------------------------ */

}
