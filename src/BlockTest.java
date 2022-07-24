import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertTrue;

class BlockTest {
    ArrayList<Block> blockchain = null;

    @BeforeEach
    public void init() {
        blockchain = new ArrayList<>();
        Block newBlock = new Block(
                "0",
                234,
                "The is a New Block.",
                new Date().getTime(),
                "0"
        );
        blockchain.add(newBlock);
    }

    @org.junit.jupiter.api.Test
    void itShouldTestCalculateBlockHash() {
        int prefix = 4;
        String prefixString = new String(new char[prefix]).replace('\0', '0');
        Block newBlock = new Block(
                "1",
                234,
                "The is a New Block.",
                new Date().getTime(),
                blockchain.get(blockchain.size() - 1).getHash()
        );
        newBlock.mineBlock(prefix);
        assertTrue(newBlock.getHash().substring(0, prefix).equals(prefixString));
        blockchain.add(newBlock);
        blockchain.forEach(System.out::println);
    }

    @org.junit.jupiter.api.Test
    void itShouldTestMineBlock() {
        //given
        //when
        //then
    }
}